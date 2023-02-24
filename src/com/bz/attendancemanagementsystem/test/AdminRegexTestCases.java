package com.bz.attendancemanagementsystem.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidAdminType;
import com.bz.attendancemanagementsystem.exception.InvalidUserNameException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.PasswordException;
import com.bz.attendancemanagementsystem.utility.AdminRegex;

public class AdminRegexTestCases {

	static AdminRegex adminRegex = new AdminRegex();
	//***************** FOR FIRSTNAME *****************//
	@Test
	public void isFirstNameStartWithCapitalTestCaseOne() {
		assertTrue(adminRegex.isFirstNameStartWithCapital("Rashmika"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartWithCapitalTestCaseTwo() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("rashmika"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartWithCapitalTestCaseThree() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("rASHMIKA"));
	}
	
	@Test(expected = FirstNameStartWithCapitalException.class)
	public void isFirstNameStartWithCapitalTestCasefour() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("RashMikA"));
	}
	
	//***************** FOR LASTNAME *****************//
	@Test
	public void isLastNameStartWithCapitalTestCaseOne() {
		assertTrue(adminRegex.isLastNameStartWithCapital("Mandana"));
	}

	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartWithCapitalTestCaseTwo() {
		assertFalse(adminRegex.isLastNameStartWithCapital("mandana"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartWithCapitalTestCaseThree() {
		assertFalse(adminRegex.isLastNameStartWithCapital("mANDANA"));
	}
	
	@Test(expected = LastNameStartWithCapitalException.class)
	public void isLastNameStartWithCapitalTestCaseFour() {
		assertFalse(adminRegex.isLastNameStartWithCapital("ManDanA"));
	}
	
	//***************** FOR TYPE OF ADMIN *****************//
	@Test
	public void isAdminTypeValidTestCaseOne() {
		assertTrue(adminRegex.isAdminTypeValid("HR"));
	}

	@Test
	public void isAdminTypeValidTestCaseTwo() {
		assertTrue(adminRegex.isAdminTypeValid("HOD"));
	}
	
	@Test(expected = InvalidAdminType.class)
	public void isAdminTypeValidTestCaseThree() {
		assertFalse(adminRegex.isAdminTypeValid("H"));
	}
	
	@Test(expected = InvalidAdminType.class)
	public void isAdminTypeValidTestCaseFour() {
		assertFalse(adminRegex.isAdminTypeValid(""));
	}
	
	//***************** FOR UserName *****************//
	@Test
	public void isUserNameValidTestCaseOne() {
		assertTrue(adminRegex.isUserNameValid("durga17u"));
	}

	@Test
	public void isUserNameValidTestCaseTwo() {
		assertTrue(adminRegex.isUserNameValid("Durga17u"));
	}
	
	@Test
	public void isUserNameValidTestCaseThree() {
		assertTrue(adminRegex.isUserNameValid("DURGA17U"));
	}
	
	@Test(expected = InvalidUserNameException.class)
	public void isUserNameValidTestCaseFour() {
		assertFalse(adminRegex.isUserNameValid("durg"));
	}
	
	@Test(expected = InvalidUserNameException.class)
	public void isUserNameValidTestCaseFive() {
		assertFalse(adminRegex.isUserNameValid(""));
	}
	
	//***************** FOR PASSWORD *****************//
		@Test
		public void isPasswordValidTestCaseOne() {
			assertTrue(adminRegex.isPasswordValid("admin12@Google"));
		}
		
		@Test
		public void isPasswordValidTestCaseTwo() {
			assertTrue(adminRegex.isPasswordValid("admin1@Google"));
		}
		@Test
		public void isPasswordValidTestCaseThree() {
			assertTrue(adminRegex.isPasswordValid("admin12@12oogle"));
		}
		@Test(expected = PasswordException.class)
		public void isPasswordValidTestCaseFour() {
			assertFalse(adminRegex.isPasswordValid("admin@12oogle"));
		}
		@Test(expected = PasswordException.class)
		public void isPasswordValidTestCaseFive() {
			assertFalse(adminRegex.isPasswordValid("admin12@"));
		}
		@Test(expected = PasswordException.class)
		public void isPasswordValidTestCaseSix() {
			assertFalse(adminRegex.isPasswordValid("admin12Google"));
		}
		@Test(expected = PasswordException.class)
		public void isPasswordValidTestCaseSeven() {
			assertFalse(adminRegex.isPasswordValid("12@12oogle"));
		}
		@Test(expected = PasswordException.class)
		public void isPasswordValidTestCaseEight() {
			assertFalse(adminRegex.isPasswordValid("12@12oogle"));
		}
}
