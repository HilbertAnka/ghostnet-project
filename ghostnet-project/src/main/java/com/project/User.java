package com.project;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class User implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String name;
	private String phonenumber;
	private String email;
	private String password;
	
	@OneToMany(mappedBy="assignedTo", fetch = FetchType.EAGER)
	private List<Ghostnet> linkedGhostnets = new ArrayList<>();
	
	
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
	
	public List<Ghostnet> getLinkedGhostnets() {
	    return linkedGhostnets;
	}

	public void setLinkedGhostnets(List<Ghostnet> linkedGhostnets) {
	    this.linkedGhostnets = linkedGhostnets;
	}
	
	public void addGhostnet(Ghostnet ghostnet) {
	    linkedGhostnets.add(ghostnet);
	    ghostnet.setAssignedTo(this);
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
