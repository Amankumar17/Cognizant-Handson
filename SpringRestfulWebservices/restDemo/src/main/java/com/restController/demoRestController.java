package com.restController;

import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class demoRestController {

	@GetMapping(path="/greet")
	public String greet()
	{
		return "Good Morning";
	}
	
	@GetMapping(path="/bye")
	public String bye()
	{
		return "Bye..!! See you soon.";
	}
	
	@GetMapping(path="/err")
	public String error()
	{
		return "Error";
	}
}
