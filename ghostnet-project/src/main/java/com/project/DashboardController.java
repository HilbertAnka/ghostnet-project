package com.project;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.*;
import java.io.IOException;

@Named
@RequestScoped
public class DashboardController {

	@Inject
	private LoginController loginController;

	@PostConstruct
	public void init() {
		
	        if (loginController.getCurrentUser() == null) {
	            try {
	                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	                ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
	            } 
	            catch (IOException e) {
	                throw new RuntimeException("Fehler bei Umleitung", e);
	            }
	        }
	    }
 }

