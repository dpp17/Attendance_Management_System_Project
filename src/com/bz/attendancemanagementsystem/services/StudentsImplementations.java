package com.bz.attendancemanagementsystem.services;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bz.attendancemanagementsystem.interfaces.IStudent;
import com.bz.attendancemanagementsystem.model.AdminModel;
import com.bz.attendancemanagementsystem.model.StudentModel;

public class StudentsImplementations implements IStudent{

	ArrayList<StudentModel> studentHouse = new ArrayList<StudentModel>();
	Scanner getInputInImplementations = new Scanner(System.in);
	@Override
	public int create(StudentModel student) {
		studentHouse.add(student);
		student.setRollNo(studentHouse.indexOf(student));
		return studentHouse.indexOf(student);
	}

	
	private void printDisplay(StudentModel student) {
		if(null != student) {			
			System.out.println("Form ::"+'\t'+"FirstName"+" :: "+"  LastName"+" :: "+"    MobileNumber"+" :: "+"      Standard");
			System.out.println(student.getRollNo()+"    "+'\t'+student.getFirstName()+'\t'+'\t'+student.getLastName()+'\t'+'\t'+student.getMobileNumber()+'\t'+'\t'+student.getStandard());		
		}
	}
	
	private void updateOptionsToSupport(StudentModel student) {
		byte option =0;
		do {
		System.out.println("Press 1: Update FirstName"+'\n'+"Press 2: Update LastName"+'\n'+"Press 3: MobileNUmber"+'\n'+"Press 4: Standard");
		option = getInputInImplementations.nextByte();
		switch(option) {
		case 1:
			System.out.println("Enter FirstName : "); 
			student.setFirstName(getInputInImplementations.next());
			break;
		case 2:
			System.out.println("Enter LastName : "); 
			student.setLastName(getInputInImplementations.next());
			break;	
		case 3:
			System.out.println("Enter MobileNumber : "); 
			student.setMobileNumber(getInputInImplementations.next());
			break;
		case 4:
			System.out.println("Enter Standard : "); 
			student.setStandard(getInputInImplementations.next());
			break;
		}
		printDisplay(student);
		System.out.println("Press 0: To Visit Update Menu "+'\n'+"Press 1: To Visit Main Menu ");
		option=getInputInImplementations.nextByte();
		}while(option == 0);
	
}
	
	@Override
	public void update(String firstName) {
		
	}

	@Override
	public void delete(String firstName) {
		studentHouse.removeAll(studentHouse.stream().filter(std->std.getFirstName().contains(firstName)).collect(Collectors.toList()));		
	}

	@Override
	public void searchById(int studentNo) {
		studentHouse.stream().filter(std->std.getRollNo() == studentNo).forEach(std->printDisplay(std));
	}

	@Override
	public void searchByFirstName(String firstName) {
		studentHouse.stream().filter(std->std.getFirstName().contains(firstName)).forEach(std->printDisplay(std));
	}

	@Override
	public void searchByLastName(String lastName) {
		studentHouse.stream().filter(std->std.getLastName().contains(lastName)).forEach(std->printDisplay(std));
	}

	@Override
	public void searchByStandard(String standard) {
		studentHouse.stream().filter(std->std.getStandard().contains(standard)).forEach(std->printDisplay(std));
	}

	@Override
	public void displayWelcome() {
		
	}

	@Override
	public void displayEnd() {
		// TODO Auto-generated method stub
		
	}

}
