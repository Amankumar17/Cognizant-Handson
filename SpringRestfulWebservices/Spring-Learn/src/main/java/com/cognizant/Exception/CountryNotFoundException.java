package com.cognizant.Exception;

import java.lang.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country Not Found")
public class CountryNotFoundException extends RuntimeException{

	public CountryNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CountryNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CountryNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CountryNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
