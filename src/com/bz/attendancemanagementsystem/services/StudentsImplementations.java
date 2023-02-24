package com.bz.attendancemanagementsystem.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidMobileNumberException;
import com.bz.attendancemanagementsystem.exception.InvalidStandardException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.interfaces.IStudent;
import com.bz.attendancemanagementsystem.interfaces.IStudentRegex;
import com.bz.attendancemanagementsystem.model.StudentModel;
import com.bz.attendancemanagementsystem.utility.StudentRegex;

public class StudentsImplementations implements IStudent{

	ArrayList<StudentModel> studentHouse = new ArrayList<StudentModel>();
	Scanner getInputInImplementations = new Scanner(System.in);
	IStudentRegex iStudentRegex = new StudentRegex();
	
	@Override
	public int create(StudentModel student) throws FirstNameStartWithCapitalException,LastNameStartWithCapitalException,InvalidMobileNumberException,InvalidStandardException{
		
		if(iStudentRegex.isFirstNameStartsWithCapital(student.getFirstName())) {
			if(iStudentRegex.isLastNameStartsWithCapital(student.getLastName())) {
				if(iStudentRegex.isMobileNumberValid(student.getMobileNumber())) {
					if(iStudentRegex.isStandardValid(student.getStandard())) {
						studentHouse.add(student);
						student.setRollNo(studentHouse.indexOf(student));
						return studentHouse.indexOf(student);
					}
				}
			}
		}
			
		return -1;
	}

	
	@Override
	public void update(String firstName) {
	studentHouse.stream().filter(std->std.getFirstName().equalsIgnoreCase(firstName)).forEach(std->updateOptionsToSupport(std));	
	}

	@Override
	public void delete(String firstName) {
		studentHouse.removeAll(studentHouse.stream().filter(std->std.getFirstName().equalsIgnoreCase(firstName)).collect(Collectors.toList()));		
	}

	@Override
	public void searchById(int studentNo) throws NoSuchElementException {
		studentHouse.stream().filter(std->std.getRollNo() == studentNo).forEach(std->printDisplay(std));
		studentHouse.stream().filter(std->std.getRollNo() == studentNo).findFirst().orElseThrow();
	}

	@Override
	public void searchByFirstName(String firstName) throws NoSuchElementException  {
		studentHouse.stream().filter(std->std.getFirstName().equalsIgnoreCase(firstName)).forEach(std->printDisplay(std));
		studentHouse.stream().filter(std->std.getFirstName().equalsIgnoreCase(firstName)).findFirst().orElseThrow();
	}

	@Override
	public void searchByLastName(String lastName) throws NoSuchElementException  {
		studentHouse.stream().filter(std->std.getLastName().equalsIgnoreCase(lastName)).forEach(std->printDisplay(std));
		studentHouse.stream().filter(std->std.getLastName().equalsIgnoreCase(lastName)).findFirst().orElseThrow();
	}

	@Override
	public void searchByStandard(String standard) throws NoSuchElementException  {
		studentHouse.stream().filter(std->std.getStandard().equalsIgnoreCase(standard)).forEach(std->printDisplay(std));
		studentHouse.stream().filter(std->std.getStandard().equalsIgnoreCase(standard)).findFirst().orElseThrow();
		
	}

	@Override
	public void displayWelcome() {
		System.err.println("====================================================");
		System.out.println("  ::  Welcome To ATTENDANCE_MANAGEMENT_SYSTEMS  ::  ");
		System.err.println("===================================================="+'\n');
	}

	@Override
	public void displayEnd() {
		System.err.println("====================================================");
		System.out.println("     ::     THANK YOU for STOPPING BY !!     ::     ");
		System.err.println("===================================================="+'\n');
		
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
}
