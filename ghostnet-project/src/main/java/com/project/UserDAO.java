package com.project;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;

@ApplicationScoped
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
		  
		  
		  //für Login-Prozess wichtig
		  public User findByUserEmail(String email) {
			    
			  
			  EntityManager entityManager = emf.createEntityManager();
			    
			  try {
			        TypedQuery<User> abfrage = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
			        abfrage.setParameter("email", email);
			        return abfrage.getSingleResult();
			  } 
			    
			    
			  catch (NoResultException e) {
			        return null; // falls email-Adresse nicht existiert und dementsprechend kein User gefunden wird
			  } 
			    
			    
			  finally {
			        entityManager.close();
			  }
			  
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
