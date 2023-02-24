package com.bz.attendancemanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.bz.attendancemanagementsystem.exception.AdminNotFoundException;
import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidAdminType;
import com.bz.attendancemanagementsystem.exception.InvalidUserNameException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.PasswordException;
import com.bz.attendancemanagementsystem.interfaces.IAdmin;
import com.bz.attendancemanagementsystem.model.AdminModel;
import com.bz.attendancemanagementsystem.services.AdminImplementations;


public class AdminController {
	
	private static Scanner getInput = new Scanner(System.in);

	public static void main(String[] args) {
		AdminModel adModel = new AdminModel();
		IAdmin getAdmin = new AdminImplementations();
		byte option = 0;
		
		getAdmin.displayWelcome();
		try {
			do {
					try {
						System.out.println(" 1: Create new Admin ::"+'\n'+" 2: Update Admin Info ::"+'\n'+" 3: Delete Admin ::"
								+'\n'+" 4: Search Admin by AdminID ::"+'\n'+" 5: Search Admin by FirstName ::"
										+'\n'+" 6: Search Admin by LastName ::");
						System.out.println('\n'+"-->>Enter Option :: ");
						switch(getInput.nextByte()) {	
	/*-- Add -- */				case 1:
									System.out.println("-->> Admin_Id :: "+ getAdmin.createAdmin(getdetails()));
									break;
	/*-- Update -- */			case 2:
									System.out.println("Enter FirstName :: ");
								getAdmin.update(getInput.next());
								break;
	/*-- Delete -- */			case 3:
									System.out.println("Enter FirstName :: ");
								getAdmin.delete(getInput.next());
								break;
	/*-- Search -- */			case 4:
	/*By Admin_Id*/					System.out.println("Enter Admin_Id :: ");
									getAdmin.searchById(getInput.nextInt());
									break;
	/*-- Search -- */			case 5:
	/*By FirstName*/			System.out.println("Enter FirstName :: ");
									getAdmin.searchByFirstName(getInput.next());
									break;
	/*-- Search -- */			case 6:
	/*By LastName*/					System.out.println("Enter LastName :: ");
									getAdmin.searchByLastName(getInput.next());	
									
									break;
									default:
										System.err.println("Invalid Option Please Try Again !!");
						}
				}catch(InputMismatchException e){
							System.out.println(e);					
				}catch(NoSuchElementException e) {
							System.out.println("------  ::  Admin not Found ::  -------");
				}catch(FirstNameStartWithCapitalException e){
					System.out.println(e);
					System.out.println("Enter Valid FirstName : "); 
					adModel.setFirstName(getInput.next());
				}catch(LastNameStartWithCapitalException e){
					System.out.println(e);
					System.out.println("Enter Valid LastName : "); 
					adModel.setFirstName(getInput.next());
				}catch(InvalidAdminType e){
					System.out.println(e);
					System.out.println("Enter Valid Admin Type : "); 
					adModel.setFirstName(getInput.next());
				}catch(InvalidUserNameException e){
					System.out.println(e);
					System.out.println("Enter Valid UserName : "); 
					adModel.setUsername(getInput.next());
				}catch(PasswordException e){
					System.out.println(e);
					System.out.println("Enter Valid Password : "); 
					adModel.setPassword(getInput.next());
				}catch(AdminNotFoundException e) {
					System.err.println(e);
				}
					
			System.out.println('\n'+"Press 1: To Main Menu "+'\n'+"Press 2: To Exit");
			option = getInput.nextByte();
			}while(option ==1);
		}catch(InputMismatchException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			getAdmin.displayEnd();
		}
	}

	
	
	//***************** GETING INPUT METHOD *****************//
		static AdminModel getdetails() {
			AdminModel getDetails = new AdminModel();
			
			System.out.println("Enter FirstName : "); 
			getDetails.setFirstName(getInput.next());
			
			System.out.println("Enter LastName : "); 
			getDetails.setLastName(getInput.next());
			
			System.out.println("Enter Type Of Admin : "); 
			getDetails.setTypeOfAdmin(getInput.next());

			System.out.println("Enter Username : "); 
			getDetails.setUsername(getInput.next());
			
			System.out.println("Enter Password : "); 
			getDetails.setPassword(getInput.next());
			
			return getDetails;
			
		}
		
		
}
