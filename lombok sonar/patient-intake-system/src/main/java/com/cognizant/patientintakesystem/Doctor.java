package com.cognizant.patientintakesystem;

public enum Doctor {
	nikhil("Nikhil Agrawal"),
	sanju("Sanju William"),
	cruz("Tony Cruz"),
	tom("Tom Holland");
	
	private String doctorName;
	
	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}
}
