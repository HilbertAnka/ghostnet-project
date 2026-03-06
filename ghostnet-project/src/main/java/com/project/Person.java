package com.project;

import java.io.Serializable;
import jakarta.inject.Named;

@Named
public class Person implements Serializable {
	
	private String firstName;
	private String name;
	private String phonenumber;
	private String email;
	private String password;
	
	public String getFirstName() {
		return "Anka";
	}
	
	public String getName() {
		return "Hilbert";	
	}
	
	public String getPhonenumber() {
		return "01573456789";	
	}
	
	public String getEmail() {
		return "anka@web.de";	
	} 
	
	public String getPassword() {
		return "1234";
	} 
}
