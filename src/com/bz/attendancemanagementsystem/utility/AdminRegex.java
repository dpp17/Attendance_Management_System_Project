package com.bz.attendancemanagementsystem.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidAdminType;
import com.bz.attendancemanagementsystem.exception.InvalidUserNameException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.PasswordException;
import com.bz.attendancemanagementsystem.interfaces.IAdminRegex;

public class AdminRegex implements IAdminRegex {

	
	@Override
	public boolean isFirstNameStartWithCapital(String firstName) {
		boolean result = checkValidation(firstName,EAdmin.VALID_NAME_PATTERN.getConstant()).find();
		if(!result) {
			throw new FirstNameStartWithCapitalException(" ***** ::  Invalid FirstName :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isLastNameStartWithCapital(String lastName) {
		boolean result = checkValidation(lastName,EAdmin.VALID_NAME_PATTERN.getConstant()).find();
		if(!result) {
			throw new LastNameStartWithCapitalException(" ***** ::  Invalid LastName :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isAdminTypeValid(String admintype) {
		boolean result = checkValidation(admintype,EAdmin.VALID_TYPE_OF_ADMIN.getConstant()).find();
		if(!result) {
			throw new InvalidAdminType(" ***** ::  Invalid Admin Type :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isUserNameValid(String username) {
		boolean result = checkValidation(username,EAdmin.VALID_USERNAME.getConstant()).find();
		if(!result) {
			throw new InvalidUserNameException(" ***** ::  Invalid LastName :: ***** ");
		}
	return result;
	}

	@Override
	public boolean isPasswordValid(String password) {
		boolean result = checkValidation(password,EAdmin.VALID_PASSWORD.getConstant()).find();
		if(!result) {
			throw new PasswordException(" ***** ::  Invalid Password :: ***** ");
		}
		return result;
	}

	
	private static Matcher checkValidation(String inputString, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(inputString);	
		return matcher;
	}
	
}
