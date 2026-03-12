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
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable {

	@Inject
	private UserDAO userDAO;
	
	private String email;
	private String password;
	private User currentUser;
	private boolean isLoggedIn;
	
	//Getter und Setter für email, password und user
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

	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	
	public boolean getIsLoggedIn() {
		return isLoggedIn;
		
	}
	public void setIsLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


	// leerer Konstruktor
	public LoginController() {
		
	}
	
	
	public void setEmailFromField (ComponentSystemEvent ev) {
		
	    UIInput input = (UIInput) ev.getComponent();
	    this.email = (String) input.getValue();
	    
	}
	
	//checkt ob Email und Login stimmen
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		this.password = (String) value;
		
		  
		if (this.email == null || this.email.isBlank()) {
		        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
		                "Bitte geben Sie zuerst die E-Mail ein.", null));
		    }
		
		User userFromDB = userDAO.findByUserEmail(this.email);
		
		   if (userFromDB == null || !userFromDB.getPassword().equals(this.password)) {
		        throw new ValidatorException(new FacesMessage("Login fehlgeschlagen! E-Mail oder Passwort falsch."));
		    }
		   
		   this.currentUser = userFromDB;

		}

	
	   public String login() {
	        if (currentUser != null) {
	            return "dashboard?faces-redirect=true"; // Weiterleitung zur Dashboard-Seite
	        }
	        return null; // Login funktioniert nicht
	    }
	
	   public String logout() {
	        // Session wird gelöscht
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        this.currentUser = null; // Benutzer wird aus der Session entfernt
	        return "index?faces-redirect=true";
	    }

	    // Hilfsmethode: Prüft, ob User eingeloggt ist
	    public boolean isLoggedIn() {
	        return currentUser != null;
	    }
	}
