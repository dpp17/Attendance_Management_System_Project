package com.bz.attendancemanagementsystem.interfaces;

import com.bz.attendancemanagementsystem.model.StudentModel;

public interface IStudent {

	void displayWelcome();
	int create(StudentModel student);
	void update(String firstName);
	void delete(String firstName);
	void searchById(int studentNo);
	void searchByFirstName(String firstName);
	void searchByLastName(String lastName);
	void searchByStandard(String standard);
	void displayEnd();
	
}
