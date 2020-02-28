package com.github.junglee.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.junglee.domain.Template;

@Service
public class TemplateService
{
	@Autowired
	TemplateRepository repo;
	public void createTemplates() {
		int[] type = {1,2};
		int[] size = {2,6};
		int[] format = {1,2,3,4};
		int[] entryFee = {2,4,6,8,10,12};
		
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
						
						repo.save( temp );
					}
				}
				
			}
		}
		
	}
	
	

}
