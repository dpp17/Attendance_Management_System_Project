package com.bz.attendancemanagementsystem.controller;

import java.util.Scanner;

import com.bz.attendancemanagementsystem.controller.AdminController;
import com.bz.attendancemanagementsystem.controller.FacultyController;
import com.bz.attendancemanagementsystem.controller.StudentController;

public class AttendanceManagementSystemMain {

	public static void main(String[] args) {

		byte option = 0;
		Scanner getInput = new Scanner(System.in);
		do {
		System.out.println('\t'+"*** USERS ***");
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
		}while(option == 1);
	}
}
