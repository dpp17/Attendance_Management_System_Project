package com.bz.attendancemanagementsystem.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bz.attendancemanagementsystem.utility.FacultyRegex;

public class FacultyRegexTestCases {

	static FacultyRegex facultyRegex = new FacultyRegex();
	//***************** FOR FIRSTNAME *****************//
	@Test
	public void isFirstNameStartWithCapitalTestCaseOne() {
		assertTrue(facultyRegex.isFirstNameStartWithCapital("Rashmika"));
	}
	
	@Test
	public void isFirstNameStartWithCapitalTestCaseTwo() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("rashmika"));
	}
	
	@Test
	public void isFirstNameStartWithCapitalTestCaseThree() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("rASHMIKA"));
	}
	
	@Test
	public void isFirstNameStartWithCapitalTestCasefour() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("RashMikA"));
	}
	
	//***************** FOR LASTNAME *****************//
	@Test
	public void isLastNameStartWithCapitalTestCaseOne() {
		assertTrue(facultyRegex.isFirstNameStartWithCapital("Mandana"));
	}

	@Test
	public void isLastNameStartWithCapitalTestCaseTwo() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("mandana"));
	}
	
	@Test
	public void isLastNameStartWithCapitalTestCaseThree() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("mANDANA"));
	}
	
	@Test
	public void isLastNameStartWithCapitalTestCaseFour() {
		assertFalse(facultyRegex.isFirstNameStartWithCapital("ManDanA"));
	}
}
