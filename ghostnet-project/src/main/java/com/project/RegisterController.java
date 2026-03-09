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
public class RegisterController implements Serializable {
	
	
	
	
	public String registerPerson2() {
		return "welcome";
}


}
