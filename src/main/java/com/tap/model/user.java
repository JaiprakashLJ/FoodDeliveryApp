package com.tap.model;

import java.sql.Timestamp;

public class user {
	
	private int userid;
	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private String role;
	private Timestamp createdDate;
	private Timestamp lastLoginDate;
	
	public user() {
		
	}
	
	public user(int userid, String name, String email, String password, String phoneNumber, String address,
			String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}
	
	

	

	public user(int userid, String name, String email, String password, String phoneNumber, String address, String role,
			Timestamp createdDate, Timestamp lastLoginDate) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}

	public user(String name,String email,String password,String phoneNumber,String address,String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}





	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "user [userid=" + userid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", role=" + role + ", createdDate="
				+ createdDate + ", lastLoginDate=" + lastLoginDate + "]";
	}

	
	
		
		
	}
	
	
	


