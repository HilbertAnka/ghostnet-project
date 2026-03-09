package com.project;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;



public class UserDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnet-ProjectPersistenceUnit");
	
	  public void saveUser(User user) {  
	  EntityManager em = emf.createEntityManager();
	  EntityTransaction t = em.getTransaction();
	  t.begin();
	  em.persist(user);
	  t.commit();
	}
	  
	  

}
