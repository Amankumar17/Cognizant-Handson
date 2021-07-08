package com.cognizant.SpringLearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan("com.*")
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		//displayDate();
		
		//displayCountry();
		
	}
	
	public static void displayDate()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		
		try {
			Date result =  format.parse("31/12/2018");
			LOGGER.debug(result.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//format.parse("31/12/2018");
		

		LOGGER.info("END");
	}
	
	public static void displayCountry()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");

		List<Country> countryList = (List<Country>) context.getBean("countryList", java.util.ArrayList.class);
		
		for(Country country : countryList)
		{
			LOGGER.debug("Country : {}", country.toString());	
		}
		LOGGER.info("END");
		
	}

}
