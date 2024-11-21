package com.NoteApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityProvider {
	
	public static EntityManager getManager() {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("Notejpa");
	EntityManager em=emf.createEntityManager();
	return em;
	
	}
	
}
