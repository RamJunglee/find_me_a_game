package com.github.junglee.jpa;

import java.util.List;

import javax.annotation.PostConstruct;

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
	
	@PostConstruct
	public void initTemplate() {
		templates = ( List< Template > ) repo.findAll();
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
	public Long getTempIdByCriteria( int prizeType, int size, int format, int entryFee )
	{
		
		return null;
	}

}
