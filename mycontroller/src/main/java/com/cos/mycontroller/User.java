package com.cos.mycontroller;

public class User {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		System.out.println("setUsername() 실행됨");
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("setPasswrod() 실행됨");
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
