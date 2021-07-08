package com.cognizant.Service;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.Exception.CountryNotFoundException;
import com.cognizant.SpringLearn.Country;

@Service
public class CountryService {

	
	public Country getCountry(String code)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		Country country = null;
		try
		{		
			country = (Country) context.getBean(code, Country.class);
		}
		catch(NoSuchBeanDefinitionException e)
		{
			throw new CountryNotFoundException();
		}
		return country;
		
	}
}
