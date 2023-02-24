package com.bz.attendancemanagementsystem.interfaces;

public interface IStudentRegex {

	boolean isFirstNameStartsWithCapital(String firstName);
	boolean isLastNameStartsWithCapital(String lastName);
	boolean isMobileNumberValid(String mobileNumber);
	boolean isStandardValid(String standard);

}
