package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeResources {

	Logger log = LoggerFactory.getLogger(HomeResources.class);
	
	@RequestMapping("/test")
	public String LogLevelsTest()
	{
		log.info("This is info message");
		log.warn("t");
		log.error("error");
		log.debug("debug");
		log.trace("trace");
		
		return "Logging levels demo";
	}
}
