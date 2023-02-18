package com.bz.attendancemanagementsystem.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidAdminType;
import com.bz.attendancemanagementsystem.exception.InvalidUserNameException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.PasswordException;
import com.bz.attendancemanagementsystem.interfaces.IFacultyRegex;

public class FacultyRegex implements IFacultyRegex{

	@Override
	public boolean isFirstNameStartWithCapital(String firstName) {
		boolean result = checkValidation(firstName,EFaculty.VALID_NAME_PATTERN.getConstant()).find();
		if(!result) {
			throw new FirstNameStartWithCapitalException(" ***** ::  Invalid FirstName :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isLastNameStartWithCapital(String lastName) {
		boolean result = checkValidation(lastName,EFaculty.VALID_NAME_PATTERN.getConstant()).find();
		if(!result) {
			throw new LastNameStartWithCapitalException(" ***** ::  Invalid LastName :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isMobileNumberValid(String mobileNumber) {
		boolean result = checkValidation(mobileNumber,EFaculty.VALID_MOBILE_NUMBER.getConstant()).find();
		if(!result) {
			throw new InvalidAdminType(" ***** ::  Invalid Admin Type :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isStandardValid(String subject) {
		boolean result = checkValidation(subject,EFaculty.VALID_STANDARD.getConstant()).find();
		if(!result) {
			throw new InvalidUserNameException(" ***** ::  Invalid LastName :: ***** ");
		}
	return result;
	}

	@Override
	public boolean isSubjectValid(String subject) {
		boolean result = checkValidation(subject,EFaculty.VALID_SUBJECT.getConstant()).find();
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
