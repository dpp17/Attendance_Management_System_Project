package com.bz.attendancemanagementsystem.services;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidMobileNumberException;
import com.bz.attendancemanagementsystem.exception.InvalidStandardException;
import com.bz.attendancemanagementsystem.exception.InvalidSubjectException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.interfaces.IFaculty;
import com.bz.attendancemanagementsystem.interfaces.IFacultyRegex;
import com.bz.attendancemanagementsystem.model.FacultyModel;
import com.bz.attendancemanagementsystem.utility.FacultyRegex;

public class FacultyImplementations implements IFaculty {

	static ArrayList<FacultyModel> facultyHouse = new ArrayList<>();
	static Scanner getFacultyImplementationInput = new Scanner(System.in);
	IFacultyRegex facultyRegex = new FacultyRegex();
	

	@Override
	public void displayWelcome() {
		System.err.println("====================================================");
		System.out.println("  ::  Welcome To ATTENDANCE_MANAGEMENT_SYSTEMS  ::  ");
		System.err.println("===================================================="+'\n');	
		
	}
	
	@Override
	public int createFaculty(FacultyModel faculty) throws FirstNameStartWithCapitalException,LastNameStartWithCapitalException,InvalidMobileNumberException,InvalidStandardException,InvalidSubjectException {
		if(facultyRegex.isFirstNameStartWithCapital(faculty.getFirstName())) {
			if(facultyRegex.isLastNameStartWithCapital(faculty.getLastName())) {
					if(facultyRegex.isMobileNumberValid(faculty.getMobileNumber())) {
						if(facultyRegex.isStandardValid(faculty.getStandard())) {					
							if(facultyRegex.isSubjectValid(faculty.getSubject())) {
								facultyHouse.add(faculty);
								printFacultyDetails(faculty);
								faculty.setFacultyNo(facultyHouse.indexOf(faculty));
								return facultyHouse.indexOf(faculty);
							}
						}
					}
			}
		}
	return -1;
	}

	private void printFacultyDetails(FacultyModel faculty) {
		if(null != faculty) {
			System.out.println("Form ::"+'\t'+"FirstName"+" :: "+"  LastName"+" :: "+"    mobileNumber"+" :: "+"      standard"+"  ::  "+"      subject");
			System.out.println(faculty.getFacultyNo()+"    "+'\t'+faculty.getFirstName()+'\t'+'\t'+faculty.getLastName()+'\t'+faculty.getMobileNumber()+'\t'+'\t'+faculty.getStandard()+'\t'+'\t'+faculty.getSubject());		
		}
	}
	
	private void updateOptionsToSupport(FacultyModel faculty) {
		byte option =0;
		do {
		System.out.println(" 1: Update FirstName"+'\n'+" 2: Update LastName"+'\n'+" 3: Update Mobile Number"+'\n'+" 4: Standard"+'\n'+" 5: Subject"+'\n');
		option = getFacultyImplementationInput.nextByte();
		switch(option) {
		case 1:
			System.out.println("Enter FirstName : "); 
			faculty.setFirstName(getFacultyImplementationInput.next());
			break;
		case 2:
			System.out.println("Enter LastName : "); 
			faculty.setLastName(getFacultyImplementationInput.next());
			break;	
		case 3:
			System.out.println("Enter Mobile_Number : "); 
			faculty.setMobileNumber(getFacultyImplementationInput.next());
			break;
		case 4:
			System.out.println("Enter Standard : "); 
			faculty.setStandard(getFacultyImplementationInput.next());
			break;
		case 5:
			System.out.println("Enter Subject : "); 
			faculty.setSubject(getFacultyImplementationInput.next());
			break;
			default:
				System.err.println("Invalid Input ..... Try Again !!");
		}
		printFacultyDetails(faculty);
		System.out.println("Press 0: To Visit Update Menu "+'\n'+"Press 1: To Visit Main Menu ");
		option=getFacultyImplementationInput.nextByte();
		}while(option == 0);
	
}
	
	
	@Override
	public void update(String firstName) {
		facultyHouse.stream().filter(fac->fac.getFirstName().contains(firstName)).forEach(fac->updateOptionsToSupport(fac));
	}

	@Override
	public void delete(String firstName) {
		facultyHouse.removeAll(facultyHouse.stream().filter(fac->fac.getFirstName().contains(firstName)).collect(Collectors.toList()));
	}

	@Override
	public void searchById(int facultyNo) throws NoSuchElementException  {
		facultyHouse.stream().filter(fac->fac.getFacultyNo() == facultyNo).forEach(fac->printFacultyDetails(fac));
		facultyHouse.stream().filter(fac->fac.getFacultyNo() == facultyNo).findFirst().orElseThrow();
	}

	@Override
	public void searchByFirstName(String firstName) throws NoSuchElementException  {
		facultyHouse.stream().filter(fac->fac.getFirstName().equalsIgnoreCase(firstName)).forEach(fac->printFacultyDetails(fac));
		facultyHouse.stream().filter(fac->fac.getFirstName().equalsIgnoreCase(firstName)).findFirst().orElseThrow();
	}

	@Override
	public void searchByLastName(String lastName) throws NoSuchElementException  {
		facultyHouse.stream().filter(fac->fac.getLastName().equalsIgnoreCase(lastName)).forEach(fac->printFacultyDetails(fac));
		facultyHouse.stream().filter(fac->fac.getLastName().equalsIgnoreCase(lastName)).findFirst().orElseThrow();
		
	}

	@Override
	public void searchBySubject(String subject) throws NoSuchElementException  {
		facultyHouse.stream().filter(fac->fac.getSubject().equalsIgnoreCase(subject)).forEach(fac->printFacultyDetails(fac));
		facultyHouse.stream().filter(fac->fac.getSubject().equalsIgnoreCase(subject)).findFirst().orElseThrow();
	}

	@Override
	public void displayEnd() {
		System.err.println("====================================================");
		System.out.println("     ::     THANK YOU for STOPPING BY !!     ::     ");
		System.err.println("===================================================="+'\n');
		
		
	}


}
