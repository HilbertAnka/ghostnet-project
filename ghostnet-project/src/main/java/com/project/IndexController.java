package com.project;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("controller")
@ViewScoped
public class IndexController implements Serializable {

	  public String goToReport() {
	        return "report-ghostnet";
	    }
	  
	  public String goToLoginRegister() {
	        return "login-register";
	    }
	    
	    public String goToIndex() {
	        return "index";
	    }
	
}
