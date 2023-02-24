package com.bz.attendancemanagementsystem.common;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bz.attendancemanagementsystem.controller.AdminController;
import com.bz.attendancemanagementsystem.controller.FacultyController;
import com.bz.attendancemanagementsystem.controller.StudentController;

public class AttendanceManagementSystemMain {
	
	static Scanner getInput = new Scanner(System.in);
	
	static void getUserOptions(String[] args) {
		do {
			System.err.println('\t'+"--------------------");
			System.out.println('\t'+"*** USERS ***");
			System.err.println('\t'+"--------------------"+'\n');
			System.out.println(" 1. Admin :: "+'\n'+" 2. Faculty :: "+'\n'+" 3. Student");
			System.out.println("Enter Option :: ");
			switch(getInput.nextByte()) {
			case 1:
				AdminController.main(args);
				break;
			case 2:
				FacultyController.main(args);
				break;
			case 3:
				StudentController.main(args);
				break;
			default:
				System.out.println("Invalid Input...");
			}	
			System.out.println(" 1. Re-Visit Menu" +'\n' + " 2. Exit ");
			}while(getInput.nextByte() == 1);
	}
	
	public static void main(String[] args) {
	
				try {	
					getUserOptions(args);
				}catch(InputMismatchException e) {
					System.out.println("---------- :: Invalid Input :: ----------");
					getUserOptions(args);	
				}
		
		
	}
}
