package com.project;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class User implements Serializable {
	
	//Assoziationen müssen noch irgendwo drübergeschrieben werden!!!
	// 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String name;
	private String phonenumber;
	private String email;
	private String password;
	
	//leerer Konstruktor
	public User() {
		
	}

	//Getter und Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFirstName() {
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
	
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User b = (User)obj;
			if (b.getEmail().equals(this.email) && 
				b.getPassword().equals(this.password)) 
				return true;
		}
		return false;
	}

}
