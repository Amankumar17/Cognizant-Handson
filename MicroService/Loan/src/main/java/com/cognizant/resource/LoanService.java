package com.cognizant.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Loan;

@RestController
public class LoanService {
	
	@RequestMapping("/loans/{loan_number}")
	public Loan getLoanDetails(@PathVariable("loan_number") String loan_number)
	{
		return new Loan(loan_number,"savings",400000,3258,18);
	}
}
