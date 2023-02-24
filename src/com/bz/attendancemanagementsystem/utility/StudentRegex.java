package com.bz.attendancemanagementsystem.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidMobileNumberException;
import com.bz.attendancemanagementsystem.exception.InvalidStandardException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.interfaces.IStudentRegex;
;

public class StudentRegex implements IStudentRegex{

	@Override
	public boolean isFirstNameStartsWithCapital(String firstName) {
		boolean result = getValidations(firstName, EStudent.FIRSTNAMESTARTWITHCAPITAL.getString()).find();
		if(!result) {
			throw new FirstNameStartWithCapitalException(" ***** ::  Invalid FirstName :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isLastNameStartsWithCapital(String lastName) {
		boolean result = getValidations(lastName, EStudent.LASTNAMESTARTWITHCAPITAL.getString()).find();
		if(!result) {
			throw new LastNameStartWithCapitalException(" ***** ::  Invalid LastName :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isMobileNumberValid(String mobileNumber) {
		boolean result = getValidations(mobileNumber, EStudent.MOBILENUMBERVALIDATION.getString()).find();
		if(!result) {
			throw new InvalidMobileNumberException(" ***** ::  Invalid MobileNUmber :: ***** ");
		}
		return result;
	}

	@Override
	public boolean isStandardValid(String standard) {
		boolean result = getValidations(standard, EStudent.LASTNAMESTARTWITHCAPITAL.getString()).find();
		if(!result) {
			throw new InvalidStandardException(" ***** ::  Invalid Standard :: ***** ");
		}
		return result;
	}

	
	private Matcher getValidations(String inputString, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(inputString);
		return matcher;
	}
	
}
