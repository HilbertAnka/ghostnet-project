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
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable {

	String email;
	User user;

	List<User> userList;
	
	public LoginController() {
		this.userList = new ArrayList<User>();
		this.userList.add(new User("anka@web.de", "1234"));
		this.userList.add(new User("selma@web.de", "4567"));
		this.user = new User();
	}
	
	public void postValidateEmail(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput)ev.getComponent();
		this.email = (String)temp.getValue();
		int breakpoint = 1;	
	}
	
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		for(User b:userList) {
			User temp=new User(this.email, (String)value);
			if(b.equals(temp))
				return;
		}
		throw new ValidatorException(new FacesMessage("Login falsch!"));
	}

	public String login() {
			return "dashboard";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
