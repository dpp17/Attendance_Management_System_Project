package com.bz.attendancemanagementsystem.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.interfaces.IStudentRegex;
import com.bz.attendancemanagementsystem.utility.StudentRegex;

public class StudentsRegexTestCases {
	
	static IStudentRegex iStudentRegex = new StudentRegex();
	
	/////////////////////// Test FirstName ///////////////////////
	@Test
	public void isFirstNameStartsWithCapitalTestCaseOne() {
		assertTrue(iStudentRegex.isFirstNameStartsWithCapital("Rashmika"));
	}

	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartsWithCapitalTestCaseTwo() {
		assertFalse(iStudentRegex.isFirstNameStartsWithCapital("rashmika"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartsWithCapitalTestCaseThree() {
		assertFalse(iStudentRegex.isFirstNameStartsWithCapital("RashMikA"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartsWithCapitalTestCaseFour() {
		assertFalse(iStudentRegex.isFirstNameStartsWithCapital("RASHMIKA"));
	}

	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartsWithCapitalTestCaseFive() {
		assertFalse(iStudentRegex.isFirstNameStartsWithCapital("rASHMIKA"));
	}
	
	/////////////////////// Test LastName ///////////////////////
	@Test
	public void isLastNameStartsWithCapitalTestCaseOne() {
	assertTrue(iStudentRegex.isLastNameStartsWithCapital("Mandana"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartsWithCapitalTestCaseTwo() {
	assertFalse(iStudentRegex.isLastNameStartsWithCapital("mandana"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartsWithCapitalTestCaseThree() {
	assertFalse(iStudentRegex.isLastNameStartsWithCapital("ManDanA"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartsWithCapitalTestCaseFour() {
	assertFalse(iStudentRegex.isLastNameStartsWithCapital("mANDANA"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartsWithCapitalTestCaseFive() {
	assertFalse(iStudentRegex.isLastNameStartsWithCapital("MANDANA"));
	}
}
