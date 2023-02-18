package com.bz.attendancemanagementsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bz.attendancemanagementsystem.exception.AdminNotFoundException;
import com.bz.attendancemanagementsystem.exception.FirstNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.InvalidAdminType;
import com.bz.attendancemanagementsystem.exception.InvalidUserNameException;
import com.bz.attendancemanagementsystem.exception.LastNameStartWithCapitalException;
import com.bz.attendancemanagementsystem.exception.PasswordException;
import com.bz.attendancemanagementsystem.interfaces.IAdmin;
import com.bz.attendancemanagementsystem.interfaces.IAdminRegex;
import com.bz.attendancemanagementsystem.model.AdminModel;
import com.bz.attendancemanagementsystem.utility.AdminRegex;

import java.util.stream.Collectors;



public class AdminImplementations implements IAdmin {

	ArrayList<AdminModel> adminHouse = new ArrayList<AdminModel>();
	Scanner getInputInImplementations = new Scanner(System.in);
	IAdminRegex adminRegex = new AdminRegex();
	 
	
	
	public void displayWelcome() {
		System.err.println("====================================================");
		System.out.println("  ::  Welcome To ATTENDANCE_MANAGEMENT_SYSTEMS  ::  ");
		System.err.println("===================================================="+'\n');	
	}
	
	public int createAdmin(AdminModel admin) throws FirstNameStartWithCapitalException,LastNameStartWithCapitalException,InvalidUserNameException,InvalidAdminType,PasswordException{
		
		if(adminRegex.isFirstNameStartWithCapital(admin.getFirstName())) {
			if(adminRegex.isLastNameStartWithCapital(admin.getLastName())) {
					if(adminRegex.isAdminTypeValid(admin.getTypeOfAdmin())) {
						if(adminRegex.isUserNameValid(admin.getUsername())) {					
							if(adminRegex.isPasswordValid(admin.getPassword())) {
							adminHouse.add(admin);
							admin.setAdminId(adminHouse.indexOf(admin));
							printDisplay(admin);
							return adminHouse.indexOf(admin);
							}
						}
					}
				}
			}	
	return -1;
	}
	
	
	private void printDisplay(AdminModel admin) {
			if(null != admin) {			
				System.out.println("Form ::"+'\t'+"FirstName"+" :: "+"  LastName"+" :: "+"    typeOfAdmin"+" :: "+"      username"+"  ::  "+"      Password");
				System.out.println(admin.getAdminId()+"    "+'\t'+admin.getFirstName()+'\t'+'\t'+admin.getLastName()+'\t'+'\t'+admin.getTypeOfAdmin()+'\t'+'\t'+admin.getUsername()+'\t'+'\t'+admin.getHiddenPassword());		
			}
	}
	
	private void updateOptionsToSupport(AdminModel admin) {
			byte option =0;
			do {
			System.out.println("Press 1: Update FirstName"+'\n'+"Press 2: Update LastName"+'\n'+"Press 3: Update Type Of Admin"+'\n'+"Press 4: UserName"+'\n'+"Press 5: Update Password"+'\n');
			option = getInputInImplementations.nextByte();
			switch(option) {
			case 1:
				System.out.println("Enter FirstName : "); 
				admin.setFirstName(getInputInImplementations.next());
				break;
			case 2:
				System.out.println("Enter LastName : "); 
				admin.setLastName(getInputInImplementations.next());
				break;	
			case 3:
				System.out.println("Enter Type Of Admin : "); 
				admin.setTypeOfAdmin(getInputInImplementations.next());
				break;
			case 4:
				System.out.println("Enter Username : "); 
				admin.setUsername(getInputInImplementations.next());
				break;
			case 5:
				System.out.println("Enter Password : "); 
				admin.setPassword(getInputInImplementations.next());
				break;
			}
			printDisplay(admin);
			System.out.println("Press 0: To Visit Update Menu "+'\n'+"Press 1: To Visit Main Menu ");
			option=getInputInImplementations.nextByte();
			}while(option == 0);
		
	}
	
	public void update(String firstName) {
		adminHouse.stream().filter(adm->adm.getFirstName().contains(firstName)).forEach(adm->updateOptionsToSupport(adm));		
	}

	public void delete(String firstName) {	
		adminHouse.removeAll(adminHouse.stream().filter(adm->adm.getFirstName().contains(firstName)).collect(Collectors.toList()));
	}

	public void searchById(int adminId) {
		
		adminHouse.stream().filter(adm->adm.getAdminId() == adminId).forEach(adm->printDisplay(adm));	
	}

	public void searchByFirstName(String firstName) {
		adminHouse.stream().filter(adm->adm.getFirstName().contains(firstName)).forEach(adm->printDisplay(adm));	
	}

	public void searchByLastName(String lastName) throws AdminNotFoundException{
		if(adminHouse.stream().filter(adm->adm.getLastName().contains(lastName)) != null) {
			adminHouse.stream().filter(adm->adm.getLastName().contains(lastName)).forEach(adm->printDisplay(adm));
		}else {
			throw new AdminNotFoundException("Admin not Found");
		}
	}

	@Override
	public void displayEnd() {
		System.err.println("====================================================");
		System.out.println("     ::     THANK YOU for STOPPING BY !!     ::     ");
		System.err.println("===================================================="+'\n');
		
	}
	
	
	
}
