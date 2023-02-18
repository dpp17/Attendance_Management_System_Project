package com.bz.attendancemanagementsystem.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.bz.attendancemanagementsystem.interfaces.IStudent;
import com.bz.attendancemanagementsystem.model.StudentModel;

public class StudentsImplementations implements IStudent{

	ArrayList<StudentModel> studentHouse = new ArrayList<StudentModel>();
	Scanner getInputInImplementations = new Scanner(System.in);
	@Override
	public int create(StudentModel student) {
		studentHouse.add(student);
		return 0;
	}

	@Override
	public void update(String firstName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String firstName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchById(int studentNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchByFirstName(String firstName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchByLastName(String lastName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchByStandard(String standard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayWelcome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayEnd() {
		// TODO Auto-generated method stub
		
	}

}
