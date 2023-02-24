package com.bz.attendancemanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidAdminType;
import com.bz.attendancemanagementsystem.exception.InvalidMobileNumberException;
import com.bz.attendancemanagementsystem.exception.InvalidStandardException;
import com.bz.attendancemanagementsystem.exception.InvalidSubjectException;
import com.bz.attendancemanagementsystem.exception.InvalidUserNameException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.PasswordException;
import com.bz.attendancemanagementsystem.interfaces.IAdmin;
import com.bz.attendancemanagementsystem.interfaces.IStudent;
import com.bz.attendancemanagementsystem.model.AdminModel;
import com.bz.attendancemanagementsystem.model.StudentModel;
import com.bz.attendancemanagementsystem.services.AdminImplementations;
import com.bz.attendancemanagementsystem.services.StudentsImplementations;

public class StudentController {

	private static Scanner getInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		StudentModel studentModel = new StudentModel();
		IStudent iStudent = new StudentsImplementations();
		byte option = 0;
		
		iStudent.displayWelcome();
		try {
		do {
			try {
		
					System.out.println(" 1: Create new Student ::"+'\n'+" 2: Update Student Info ::"+'\n'+" 3: Delete Student ::"
							+'\n'+" 4: Search Admin by StudentID ::"+'\n'+" 5: Search Student by FirstName ::"
									+'\n'+" 6: Search Student by LastName ::");
					System.out.println('\n'+"-->>Enter Option :: ");
					switch(getInput.nextByte()) {	
/*-- Add -- */				case 1:
								System.out.println("-->> Student_RollNo :: "+ iStudent.create(getdetails()));
								break;
/*-- Update -- */			case 2:
								System.out.println("Enter FirstName :: ");
								iStudent.update(getInput.next());
							break;
/*-- Delete -- */			case 3:
								System.out.println("Enter FirstName :: ");
								iStudent.delete(getInput.next());
							break;
/*-- Search -- */			case 4:
/*By Admin_Id*/					System.out.println("Enter StudentID :: ");
								iStudent.searchById(getInput.nextInt());
								break;
/*-- Search -- */			case 5:
/*By FirstName*/				System.out.println("Enter FirstName :: ");
								iStudent.searchByFirstName(getInput.next());
								break;
/*-- Search -- */			case 6:
/*By LastName*/					System.out.println("Enter LastName :: ");
								iStudent.searchByLastName(getInput.next());
								break;
								default:
									System.err.println("Invalid Option Please Try Again !!");
					}
			}catch(FirstNameStartWithCapitalException e){
				System.out.println(e);
				System.out.println("Enter Valid FirstName : "); 
				studentModel.setFirstName(getInput.next());
			}catch(LastNameStartWithCapitalException e){
				System.out.println(e);
				System.out.println("Enter Valid LastName : "); 
				studentModel.setFirstName(getInput.next());
			}catch(InvalidMobileNumberException e){
				System.out.println(e);
				System.out.println("Enter Valid Mobile_Number : "); 
				studentModel.setMobileNumber(getInput.next());
			}catch(InvalidStandardException e){
				System.out.println(e);
				System.out.println("Enter Valid Standard : "); 
				studentModel.setStandard(getInput.next());
			}catch(InputMismatchException e){
				System.out.println(e);
			}
				
		System.out.println('\n'+"Press 1: To Main Menu "+'\n'+"Press 2: To Exit");
		option = getInput.nextByte();
		}while(option ==1);
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
	
		iStudent.displayEnd();
		}


	}

	//***************** GETING INPUT METHOD *****************//
			static StudentModel getdetails() {
				StudentModel getDetails = new StudentModel();
				
				System.out.println("Enter FirstName : "); 
				getDetails.setFirstName(getInput.next());
				
				System.out.println("Enter LastName : "); 
				getDetails.setLastName(getInput.next());
				
				System.out.println("Enter Mobile_Number : "); 
				getDetails.setMobileNumber(getInput.next());

				System.out.println("Enter Standard : "); 
				getDetails.setStandard(getInput.next());
				
				return getDetails;
				
			}
	
}
