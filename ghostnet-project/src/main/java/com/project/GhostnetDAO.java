package com.project;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;



public class GhostnetDAO {
	
	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnet-ProjectPersistenceUnit");
	
	  public void saveGhostnet(Ghostnet ghostnet) {  
	  EntityManager em = emf.createEntityManager();
	  EntityTransaction t = em.getTransaction();
	  t.begin();
	  em.persist(ghostnet);
	  t.commit();
	}
	  
//	  public List<Ghostnet> findAll() {
//		  
//		  EntityManager entityManager emf.createEntityManager();
//		  Query abfrage = entityManager.createQuery("select a from Ghostnet a");
//		  List<Ghostnet> allGhostnet = abfrage.getResultList();
//		  entityManager.close();
//		  return allGhosnet;
//		
//		  
//	  }
//	  

}
