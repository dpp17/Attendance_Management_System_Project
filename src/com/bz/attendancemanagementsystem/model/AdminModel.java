package com.bz.attendancemanagementsystem.model;

public class AdminModel {

	private int adminId;
	private String firstName;
	private String lastName;
	private String typeOfAdmin;
	private String username;
	private String password;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTypeOfAdmin() {
		return typeOfAdmin;
	}
	public void setTypeOfAdmin(String typeOfAdmin) {
		this.typeOfAdmin = typeOfAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	
	public String getHiddenPassword() {
		String str = "";
		for(int i = 0; i < getPassword().length(); i++) {
			str = str + "*";
		}
		return str;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
