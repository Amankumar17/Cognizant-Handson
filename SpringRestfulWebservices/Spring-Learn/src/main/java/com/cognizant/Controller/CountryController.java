package com.cognizant.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Exception.CountryNotFoundException;
import com.cognizant.Service.CountryService;
import com.cognizant.SpringLearn.Country;
import com.cognizant.SpringLearn.SpringLearnApplication;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@Autowired
	private CountryService service;

	@RequestMapping("/country")
	public Country getCountryIndia()
	{
		LOGGER.info("start of getCountryIndia()");
		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");

		Country country = (Country) context.getBean("IN", Country.class);
		
//		for(Country country : countryList)
//		{
			LOGGER.debug("Country : {}", country.toString());	
//		}
		LOGGER.info("End of getCountryIndia()");
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries()
	{
		LOGGER.info("start of getAllCountries()");
		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");

		List<Country> countryList = (List<Country>) context.getBean("countryList", java.util.ArrayList.class);
		
		for(Country country : countryList)
		{
			LOGGER.debug("Country : {}", country.toString());	
		}
		LOGGER.info("End of getAllCountries()");
		return countryList;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		LOGGER.info("start of getCountry()");
						
		
		LOGGER.info("End of getCountry()");
		return service.getCountry(code.toUpperCase());
	}
	
}
