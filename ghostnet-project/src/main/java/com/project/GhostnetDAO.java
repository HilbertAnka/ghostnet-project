package com.project;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;


@ApplicationScoped
public class GhostnetDAO {
	
	
	
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnet-ProjectPersistenceUnit");
	
	
	
	
	  public void saveGhostnet(Ghostnet ghostnet) {  
		  
		  EntityManager entityManager = emf.createEntityManager();
		  EntityTransaction t = entityManager.getTransaction();
		  t.begin();
		  entityManager.merge(ghostnet);
		  t.commit();
		  
		  entityManager.close();
	  
	  }
	  
	  public List<Ghostnet> findAll() {
		  
		  EntityManager entityManager = emf.createEntityManager();
		  Query abfrage = entityManager.createQuery("select g from Ghostnet g");
		  List<Ghostnet> allGhostnet = abfrage.getResultList();
		  entityManager.close();
		  return allGhostnet;
		  
	  }
	  
	  
	  public void removeGhostnet(Ghostnet ghostnet) {  
		  
		  EntityManager entityManager = emf.createEntityManager();
		  EntityTransaction t = entityManager.getTransaction();
		  t.begin();
		  entityManager.remove(ghostnet);
		  t.commit();
		  
		  entityManager.close();
	  }

}
