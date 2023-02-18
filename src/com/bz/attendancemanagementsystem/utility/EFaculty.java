package com.bz.attendancemanagementsystem.utility;

public enum EFaculty {

	VALID_NAME_PATTERN("^[A-Z][a-z]+$"),
	VALID_MOBILE_NUMBER("^+91\\s[6789]\\d{9}$"),
	VALID_STANDARD("^\\d{1,2}$"),
	VALID_SUBJECT("^\\w{4,}$");
	

	String constant;
	EFaculty(String constant) {
		this.constant=constant;
	}
	public String getConstant() {
		return constant;
	}
}
