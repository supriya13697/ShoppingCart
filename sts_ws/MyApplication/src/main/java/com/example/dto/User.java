package com.example.dto;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class User {

	private String uName;
	private String password;
	
	
	public User(String uName, String password) {
		super();
		this.uName = uName;
		this.password = password;
	}
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uName=" + uName + ", password=" + password + "]";
	}



}
