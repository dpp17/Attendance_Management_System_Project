package com.bz.attendancemanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidMobileNumberException;
import com.bz.attendancemanagementsystem.exception.InvalidStandardException;
import com.bz.attendancemanagementsystem.exception.InvalidSubjectException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.interfaces.IFaculty;
import com.bz.attendancemanagementsystem.model.FacultyModel;
import com.bz.attendancemanagementsystem.services.FacultyImplementations;

public class FacultyController {

	private static Scanner getInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		FacultyModel fModel = new FacultyModel();
		IFaculty getFaculty = new FacultyImplementations();
		byte option = 0;
		
		getFaculty.displayWelcome();
		try {
		do {
				try {
					System.out.println(" 1: Create new Faculty ::"+'\n'+" 2: Update Faculty Info ::"+'\n'+" 3: Delete Faculty ::"
							+'\n'+" 4: Search Faculty Number ::"+'\n'+" 5: Search by Faculty FirstName ::"
									+'\n'+" 6: Search by Faculty LastName ::"+'\n'+" 7: Search by Faculty Subject ::");
					System.out.println('\n'+"-->>Enter Option :: ");
					switch(getInput.nextByte()) {	
/*-- Add -- */				case 1:
								System.out.println("-->> Admin_Id :: "+ getFaculty.createFaculty(getdetails()));
								break;
/*-- Update -- */			case 2:
								System.out.println("Enter FirstName :: ");
							getFaculty.update(getInput.next());
							break;
/*-- Delete -- */			case 3:
								System.out.println("Enter FirstName :: ");
							getFaculty.delete(getInput.next());
							break;
/*-- Search -- */			case 4:
/*By Admin_Id*/					System.out.println("Enter Faculty Number :: ");
								getFaculty.searchById(getInput.nextInt());
								break;
/*-- Search -- */			case 5:
/*By FirstName*/			System.out.println("Enter FirstName :: ");
								getFaculty.searchByFirstName(getInput.next());
								break;
/*-- Search -- */			case 6:
/*By LastName*/					System.out.println("Enter LastName :: ");
								getFaculty.searchByLastName(getInput.next());
								break;
							case 7:
								System.out.println("Enter Subject :: ");
								getFaculty.searchBySubject(getInput.next());
							break;
								default:
									System.err.println("Invalid Option Please Try Again !!");
					}
			}catch(FirstNameStartWithCapitalException e){
				System.out.println(e);
				System.out.println("Enter Valid FirstName : "); 
				fModel.setFirstName(getInput.next());
			}catch(LastNameStartWithCapitalException e){
				System.out.println(e);
				System.out.println("Enter Valid LastName : "); 
				fModel.setFirstName(getInput.next());
			}catch(InvalidMobileNumberException e){
				System.out.println(e);
				System.out.println("Enter Valid Mobile_Number : "); 
				fModel.setMobileNumber(getInput.next());
			}catch(InvalidStandardException e){
				System.out.println(e);
				System.out.println("Enter Valid Standard : "); 
				fModel.setStandard(getInput.next());
			}catch(InvalidSubjectException e){
				System.out.println(e);
				System.out.println("Enter Valid Subject : "); 
				fModel.setSubject(getInput.next());
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
			getFaculty.displayEnd();
		}

	}

	
	//***************** GETING INPUT METHOD *****************//
		static FacultyModel getdetails() {
			FacultyModel getDetails = new FacultyModel();
			
			System.out.println("Enter FirstName : "); 
			getDetails.setFirstName(getInput.next());
			
			System.out.println("Enter LastName : "); 
			getDetails.setLastName(getInput.next());
			
			System.out.println("Enter Mobile Number : "); 
			getDetails.setMobileNumber(getInput.next());

			System.out.println("Enter Standard : "); 
			getDetails.setStandard(getInput.next());
			
			System.out.println("Enter Subject : "); 
			getDetails.setSubject(getInput.next());
			
			return getDetails;
			
		}
		
	
	
	
}
