package com.cognizant.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Account;

@RestController
public class AccountService {
	
	@RequestMapping("/accounts/{acc_number}")
	public Account getAccountDetails(@PathVariable("acc_number") String acc_number)
	{
		return new Account(acc_number,"savings",234343);
	}
}
