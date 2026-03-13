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
	@Inject
	private LoginController loginController;
	
	
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
	
	//Registrierung eines neuen Users inkl. Prüfverfahren
	public String addUser() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
				// Prüfen, ob E-Mail-Adresse schon existiert
			  	if(userDAO.findByUserEmail(user.getEmail()) != null) {
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
			            "Diese E-Mail-Adresse ist bereits registriert.", null));
			        return null; 
			    }
	
			    // Prüfen, ob E-Mail-Format gültig ist
			    if(user.getEmail() == null || !user.getEmail().matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
			            "Bitte geben Sie eine gültige E-Mail-Adresse ein.", null));
			        return null;
			    }
	
			    // Telefonnummer darf nur Zahlen enthalten
			    if(user.getPhonenumber() == null || !user.getPhonenumber().matches("\\d+")) {
			        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
			            "Die Telefonnummer darf nur Zahlen enthalten.", null));
			        return null;
			    }
		
		userDAO.saveUser(user);
		loginController.setCurrentUser(user);
		user = new User();
		return "welcome?faces-redirect=true";
	}
	
	/* Kann später noch hinzugefügt und erweitert werden
	public void removeUser(User u) {
		userDAO.removeUser(u);
	}
	*/
	
	
	

}
