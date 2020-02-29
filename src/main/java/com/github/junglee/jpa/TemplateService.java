package com.github.junglee.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.josql.Query;
import org.josql.QueryExecutionException;
import org.josql.QueryParseException;
import org.josql.QueryResults;
import org.josql.expressions.ExpressionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.junglee.domain.Template;
import com.github.junglee.domain.TemplateDto;

@Service
public class TemplateService
{
	@Autowired
	TemplateRepository repo;
	
	List< Template > templates;
	
	String mapKey = "type: #type#|size: #size#|format: #format#";
	
	Map<String, List<Template>> tempMap;
	
	@PostConstruct
	public void initTemplate() {
		tempMap = new HashMap< String, List<Template> >();
		List<Template> l = new ArrayList<>();
		templates = ( List< Template > ) repo.findAll();
		System.out.println( "templates map **************"+ templates );
		for(Template t : templates) {
			String key = mapKey.replaceAll( "#type#", t.getType()+"" ).replaceAll( "#size#", t.getSize()+"" ).replaceAll( "#format#", t.getFormat()+"" );
			List<Template> 	lmap = 	tempMap.get( key );
			if(lmap ==null) {
				lmap = new ArrayList<>();
				lmap.add( t );
				tempMap.put( key, lmap );
			}else {
				lmap.add( t );
				tempMap.put( key, lmap );
			}
		}
		
		
		System.out.println( "temp map **************"+ tempMap );
		
	}
	
	public List< Template > createTemplates(TemplateDto dto) {
		int[] type = dto.getPrizeType();
		int[] size = dto.getSize();
		int[] format = dto.getFormat();
		int[] entryFee = dto.getEntryFee();
		
		for(int i =0; i<type.length;i++)
		{
			for(int j=0; j<size.length; j++) 
			{
				for(int k=0;k<format.length;k++)
				{
					for(int l=0;l<entryFee.length;l++)
					{
						//System.out.println( type[i] +" "+ size[j] + " "+ format[k]+ "  "+entryFee[l]);
						Template temp = new Template();
						temp.setEntryFee( entryFee[l] );
						temp.setFormat( format[k] );
						temp.setSize( size[j] );
						temp.setType( type[i] );
						try {
						repo.save( temp );
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		}
		// need to add redis pubsub for reloading the temps 
		return ( List< Template > ) repo.findAll();
		
	}
	public List< Template > getAllTemps()
	{
		return ( List< Template > ) repo.findAll();
	}
	
	public Template getTemplateById(long tempId) {
		return repo.findOne( tempId );
	}
	public Long getTempIdByCriteria( int prizeType, int size, int format, int entryFee ) throws QueryParseException, QueryExecutionException
	{
		String key = mapKey.replaceAll( "#type#", prizeType+"" ).replaceAll( "#size#", size+"" ).replaceAll( "#format#", format+"" );
		List<Template> temps = tempMap.get( key );
		Query q = new Query();
		 q.parse("SELECT * FROM com.github.junglee.domain.Template WHERE entryFee=:entryFee ");
		 q.setVariable("entryFee", entryFee);
		 
		 QueryResults execute = q.execute(temps);
		 List<Template> results = execute.getResults();
		 
		return  results.size()>0?results.get( 0 ).getId():0;

	}

}
