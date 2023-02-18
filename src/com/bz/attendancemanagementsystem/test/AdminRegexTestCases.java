package com.bz.attendancemanagementsystem.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bz.attendancemanagementsystem.utility.AdminRegex;

public class AdminRegexTestCases {

	static AdminRegex adminRegex = new AdminRegex();
	//***************** FOR FIRSTNAME *****************//
	@Test
	public void isFirstNameStartWithCapitalTestCaseOne() {
		assertTrue(adminRegex.isFirstNameStartWithCapital("Rashmika"));
	}
	
	@Test
	public void isFirstNameStartWithCapitalTestCaseTwo() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("rashmika"));
	}
	
	@Test
	public void isFirstNameStartWithCapitalTestCaseThree() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("rASHMIKA"));
	}
	
	@Test
	public void isFirstNameStartWithCapitalTestCasefour() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("RashMikA"));
	}
	
	//***************** FOR LASTNAME *****************//
	@Test
	public void isLastNameStartWithCapitalTestCaseOne() {
		assertTrue(adminRegex.isFirstNameStartWithCapital("Mandana"));
	}

	@Test
	public void isLastNameStartWithCapitalTestCaseTwo() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("mandana"));
	}
	
	@Test
	public void isLastNameStartWithCapitalTestCaseThree() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("mANDANA"));
	}
	
	@Test
	public void isLastNameStartWithCapitalTestCaseFour() {
		assertFalse(adminRegex.isFirstNameStartWithCapital("ManDanA"));
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
	
	@Test
	public void isAdminTypeValidTestCaseThree() {
		assertFalse(adminRegex.isAdminTypeValid("H"));
	}
	
	@Test
	public void isAdminTypeValidTestCaseFour() {
		assertFalse(adminRegex.isAdminTypeValid(""));
	}
	
	//***************** FOR TYPE OF ADMIN *****************//
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
	
	@Test
	public void isUserNameValidTestCaseFour() {
		assertFalse(adminRegex.isUserNameValid("durg"));
	}
	
	@Test
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
		@Test
		public void isPasswordValidTestCaseFour() {
			assertFalse(adminRegex.isPasswordValid("admin@12oogle"));
		}
		@Test
		public void isPasswordValidTestCaseFive() {
			assertFalse(adminRegex.isPasswordValid("admin12@"));
		}
		@Test
		public void isPasswordValidTestCaseSix() {
			assertFalse(adminRegex.isPasswordValid("admin12Google"));
		}
		@Test
		public void isPasswordValidTestCaseSeven() {
			assertFalse(adminRegex.isPasswordValid("12@12oogle"));
		}
		@Test
		public void isPasswordValidTestCaseEight() {
			assertFalse(adminRegex.isPasswordValid("12@12oogle"));
		}
}
