package com.project;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
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
public class GhostnetController implements Serializable {

	
	@Inject
    private GhostnetDAO ghostnetDAO;
	
	private Ghostnet ghostnet = new Ghostnet(); 
	private List<Ghostnet> allSavedGhostnets;
	
	 @PostConstruct //init wird beim Laden der Seite ausgeführt - alle Ghostnets aus der Datenbank geladen
	public void init() {
	    allSavedGhostnets = ghostnetDAO.findAll();
	}
	

	//Getter und Setter für Ghostnet und allSavedGhostnets
	public Ghostnet getGhostnet() {
		return ghostnet;
	}
	public void setGhostnet(Ghostnet ghostnet) {
		this.ghostnet = ghostnet;
	}

	public List<Ghostnet> getAllSavedGhostnets() {
		return allSavedGhostnets;
	}
	public void setAllSavedGhostnets(List<Ghostnet> allSavedGhostnets) {
		this.allSavedGhostnets = allSavedGhostnets;
	}


	//leerer Konstruktor
	public GhostnetController() {
		
	}
	
	
	public void addGhostnet() {
		ghostnetDAO.saveGhostnet(ghostnet); //Methode von GhostnetDAO zum Speichern eines neuen Ghostnets wird aufgerufen 
		allSavedGhostnets = ghostnetDAO.findAll(); //Liste wird aktualisiert
		ghostnet = new Ghostnet(); // Formular wird wieder auf 0 zuürckgesetzt
	}
	
	public void removeGhostnet(Ghostnet g) {
		ghostnetDAO.removeGhostnet(g);
		allSavedGhostnets = ghostnetDAO.findAll(); //Methode von GhostnetDAO zum Entfernen eines bestimmten Ghostnets (g)
		
	}
	
	public void loadGhostnetlist() {
		allSavedGhostnets = ghostnetDAO.findAll();
	}
	
	
	
	
	
}
