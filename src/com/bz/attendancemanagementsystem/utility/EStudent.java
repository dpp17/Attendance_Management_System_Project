package com.bz.attendancemanagementsystem.utility;

public enum EStudent {

	FIRSTNAMESTARTWITHCAPITAL("^[A-Z][a-z]{2,}$"),
	LASTNAMESTARTWITHCAPITAL("^[A-Z][a-z]{2,}$"),
	MOBILENUMBERVALIDATION("+91//s[6789][0-9]{9}"),
	STANDARDVALIDATION("^[XIV]{1,4}$");

	String constant;
	EStudent(String constant) {
		this.constant = constant;
	}
	public String getString() {
		return constant;
	}
	
}
