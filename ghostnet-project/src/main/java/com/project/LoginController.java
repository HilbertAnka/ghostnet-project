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
	Person person;

	List<Person> personlist;
	
	public LoginController() {
		this.personlist = new ArrayList<Person>();
		this.personlist.add(new Person("anka@web.de", "1234"));
		this.personlist.add(new Person("selma@web.de", "4567"));
		this.person = new Person();
	}
	
	public void postValidateEmail(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput)ev.getComponent();
		this.email = (String)temp.getValue();
		int breakpoint = 1;	
	}
	
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		for(Person b:personlist) {
			Person temp=new Person(this.email, (String)value);
			if(b.equals(temp))
				return;
		}
		throw new ValidatorException(new FacesMessage("Login falsch!"));
	}

	public String login() {
		int breakpoint = 1;
		if (this.email.equals("anka@web.de"))
			return "dashboard";
		else
			return "index";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
}
