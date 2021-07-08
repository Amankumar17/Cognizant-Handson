package com.cognizant.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SpringLearn.SpringLearnApplication;

@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	
	
	@RequestMapping("/hello")
	public String sayHello()
	{	
		LOGGER.info("START of SayHello");
		String greet = "Hello World..!!";
		LOGGER.info("End of SayHello");
		return greet;
	}
	
	
}
