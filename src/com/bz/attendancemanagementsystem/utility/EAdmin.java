package com.bz.attendancemanagementsystem.utility;

public enum EAdmin {

	VALID_NAME_PATTERN("^[A-Z][a-z]+$"),
	VALID_TYPE_OF_ADMIN("^[A-Z]{2,}$"),
	VALID_USERNAME("^\\w{5,}$"),
	VALID_PASSWORD("^admin\\d+@\\w+$");
	

	String constant;
	EAdmin(String constant) {
		this.constant=constant;
	}
	public String getConstant() {
		return constant;
	}
	
	
}
