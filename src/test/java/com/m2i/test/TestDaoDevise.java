package com.m2i.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestDaoDevise {
	
	//version sans Spring
	public static void main(String[] args) {
		//1. créer l'objet technique EntityManagerFactory de JPA 
		//en analysant le fichier META-INF/persitence.xml
		EntityManagerFactory entityManagerFactory =
				 Persistence.createEntityManagerFactory("myPersistenceUnitName");
		
		//2. créer le EntityManager via la factory
		
		
		//3. créer le DaoDeviseJpa et appeler .setEntityManager()
		
		
		//4. appeler et tester des méthodes sur le DAO
		
		
		//5. fermer le EntityManager
		
		
		//6. Fermer le EntityMangerFactory
		
	}

}
