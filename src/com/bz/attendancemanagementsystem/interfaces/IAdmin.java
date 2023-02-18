package com.bz.attendancemanagementsystem.interfaces;

import com.bz.attendancemanagementsystem.model.AdminModel;

public interface IAdmin {

	void displayWelcome();
	int createAdmin(AdminModel admin);
	void update(String firstName);
	void delete(String firstName);
	void searchById(int adminId);
	void searchByFirstName(String firstName);
	void searchByLastName(String lastName);
	void displayEnd();
	
}
