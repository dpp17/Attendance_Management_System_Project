package com.bz.attendancemanagementsystem.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.utility.FacultyRegex;

public class FacultyRegexTestCases {

	static FacultyRegex facultyRegex = new FacultyRegex();
	//***************** FOR FIRSTNAME *****************//
	@Test
	public void isFirstNameStartWithCapitalTestCaseOne() {
		assertTrue(facultyRegex.isFirstNameStartWithCapital("Rashmika"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartWithCapitalTestCaseTwo() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("rashmika"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartWithCapitalTestCaseThree() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("rASHMIKA"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartWithCapitalTestCasefour() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("RashMikA"));
	}
	
	//***************** FOR LASTNAME *****************//
	@Test
	public void isLastNameStartWithCapitalTestCaseOne() {
		assertTrue(facultyRegex.isLastNameStartWithCapital("Mandana"));
	}

	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartWithCapitalTestCaseTwo() {
		assertFalse(facultyRegex.isLastNameStartWithCapital("mandana"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartWithCapitalTestCaseThree() {
		assertFalse(facultyRegex.isLastNameStartWithCapital("mANDANA"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartWithCapitalTestCaseFour() {
		assertFalse(facultyRegex.isLastNameStartWithCapital("ManDanA"));
	}
}
