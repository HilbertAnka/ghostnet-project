package com.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;


@Named
@ApplicationScoped
public class Ghostnetlist implements Serializable {
	private static Ghostnetlist instance = new Ghostnetlist();
	private List<Ghostnet> liste = new ArrayList<Ghostnet>();
	
	public Ghostnetlist() {
		liste.add(new Ghostnet("1", "-5.615986", "-17.753906", "06.03.2026", "4", "gemeldet"));
		liste.add(new Ghostnet("2", "-5.698986", "-17.773906", "06.03.2026", "7", "verschollen"));
		liste.add(new Ghostnet("3", "-5.635986", "-17.753906", "06.03.2026", "2", "gemeldet"));
		liste.add(new Ghostnet("4", "-5.615986", "-17.753506", "06.03.2026", "16", "gemeldet"));
		liste.add(new Ghostnet("5", "-5.637986", "-17.758606", "06.03.2026", "8", "geborgen"));
		liste.add(new Ghostnet("6", "-5.682986", "-17.752306", "06.03.2026", "22", "gemeldet"));
	}
	
	public static Ghostnetlist getInstance() {
		return instance;
	}
	
	public List<Ghostnet> getListe() {
		return liste;
	} 

}
