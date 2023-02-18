package com.bz.attendancemanagementsystem.interfaces;

public interface IFacultyRegex {

	 boolean isFirstNameStartWithCapital(String firstName);
	 boolean isLastNameStartWithCapital(String lastName);
	 boolean isMobileNumberValid(String admintype);
	 boolean isStandardValid(String username);
	 boolean isSubjectValid(String password);
}
