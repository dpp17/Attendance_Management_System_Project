package com.bz.attendancemanagementsystem.interfaces;

public interface IAdminRegex {

	boolean isFirstNameStartWithCapital(String firstName);
	boolean isLastNameStartWithCapital(String lastName);
	boolean isAdminTypeValid(String admintype);
	boolean isUserNameValid(String username);
	boolean isPasswordValid(String password);
	
}
