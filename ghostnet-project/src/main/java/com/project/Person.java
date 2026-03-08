package com.project;

import java.io.Serializable;
import jakarta.inject.Named;

@Named
public class Person implements Serializable {
	
	//private String firstName;
	//private String name;
	//private String phonenumber;
	private String email;
	private String password;
	
	
	/*public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}*/
	
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
	
	public Person(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Person() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person b = (Person)obj;
			if (b.getEmail().equals(this.email) && 
				b.getPassword().equals(this.password)) 
				return true;
		}
		return false;
	}

}
