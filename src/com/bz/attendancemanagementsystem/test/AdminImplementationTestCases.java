package com.bz.attendancemanagementsystem.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bz.attendancemanagementsystem.interfaces.IAdmin;
import com.bz.attendancemanagementsystem.model.AdminModel;
import com.bz.attendancemanagementsystem.services.AdminImplementations;

public class AdminImplementationTestCases {

	
	
	static IAdmin iAdmin = new AdminImplementations();
	
	@Test
	public void createAdminTestCaseOne() {
		AdminModel adminModel = new AdminModel();
		adminModel.setFirstName("Durga");
		adminModel.setLastName("Prasad");
		adminModel.setTypeOfAdmin("HR");
		adminModel.setUsername("durga17u");
		adminModel.setPassword("admin12@Google");

		assertEquals(0, iAdmin.createAdmin(adminModel));
	}

	@Test
	public void createAdminTestCaseTwo() {
		AdminModel adminModel = new AdminModel();
		adminModel.setFirstName("durga");	//error
		adminModel.setLastName("Prasad");
		adminModel.setTypeOfAdmin("HR");
		adminModel.setUsername("durga17u");
		adminModel.setPassword("admin12@Google");

		assertEquals(-1, iAdmin.createAdmin(adminModel));
	}

	@Test
	public void createAdminTestCaseThree() {
		AdminModel adminModel = new AdminModel();
		adminModel.setFirstName("Durga");
		adminModel.setLastName("PraSad");	//error
		adminModel.setTypeOfAdmin("HR");
		adminModel.setUsername("durga17u");
		adminModel.setPassword("admin12@Google");

		assertEquals(-1, iAdmin.createAdmin(adminModel));
	}

	@Test
	public void createAdminTestCaseFour() {
		AdminModel adminModel = new AdminModel();
		adminModel.setFirstName("Durga");
		adminModel.setLastName("Prasad");
		adminModel.setTypeOfAdmin("H");	//error
		adminModel.setUsername("durga17u");
		adminModel.setPassword("admin12@Google");

		assertEquals(-1, iAdmin.createAdmin(adminModel));
	}

	@Test
	public void createAdminTestCaseFive() {
		AdminModel adminModel = new AdminModel();
		adminModel.setFirstName("Durga");
		adminModel.setLastName("Prasad");
		adminModel.setTypeOfAdmin("HR");
		adminModel.setUsername("durg");	//error
		adminModel.setPassword("admin12@Google");

		assertEquals(-1, iAdmin.createAdmin(adminModel));
	}

	@Test
	public void createAdminTestCaseSix() {
		AdminModel adminModel = new AdminModel();
		adminModel.setFirstName("Durga");
		adminModel.setLastName("Prasad");
		adminModel.setTypeOfAdmin("HR");
		adminModel.setUsername("durga17u");
		adminModel.setPassword("12@Google");	//error

		assertEquals(-1, iAdmin.createAdmin(adminModel));
	}
}
