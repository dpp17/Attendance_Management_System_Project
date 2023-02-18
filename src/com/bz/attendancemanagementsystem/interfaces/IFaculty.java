package com.bz.attendancemanagementsystem.interfaces;

import com.bz.attendancemanagementsystem.model.FacultyModel;

public interface IFaculty {
	
	void displayWelcome();
	int createFaculty(FacultyModel faculty);
	void update(String firstName);
	void delete(String firstName);
	void searchById(int facultyNo);
	void searchByFirstName(String firstName);
	void searchByLastName(String lastName);
	void searchBySubject(String subject);
	void displayEnd();
	
	
}
