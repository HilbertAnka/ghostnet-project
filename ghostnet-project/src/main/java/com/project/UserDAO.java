package com.project;


import java.util.List;

import jakarta.persistence.*;


public class UserDAO {
	
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnet-ProjectPersistenceUnit");
	
	 
	  
		  public void saveUser(User user) {  
			  
			  EntityManager entityManager = emf.createEntityManager();
			  EntityTransaction t = entityManager.getTransaction();
			  t.begin();
			  entityManager.persist(user);
			  t.commit();
			  
			  entityManager.close();
			  
		  }
		  
		  public List<User> findAll() {
			  
			  EntityManager entityManager = emf.createEntityManager();
			  Query abfrage = entityManager.createQuery("select u from User u");
			  List<User> allUser = abfrage.getResultList();
			  entityManager.close();
			  return allUser;
			  
		  }
		  
		  
		  public void removeUser(User user) {  
			  
			  EntityManager entityManager = emf.createEntityManager();
			  EntityTransaction t = entityManager.getTransaction();
			  t.begin();
			  entityManager.remove(user);
			  t.commit();
			  
			  entityManager.close();
		  }  

}
