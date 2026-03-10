package com.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@ViewScoped
public class RegisterController implements Serializable {
	
	@Inject
	private UserDAO userDAO;
	
	private User user = new User();
	
	
	//Getter und Setter für user
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



	
	// leerer Konstruktor
	public RegisterController() {
		
	}
	
	
	public String addUser() {
		userDAO.saveUser(user);
		user = new User();
		return "welcome";
	}
	
	public void removeUser(User u) {
		userDAO.removeUser(u);
		
	}
	
	
	
	

}
