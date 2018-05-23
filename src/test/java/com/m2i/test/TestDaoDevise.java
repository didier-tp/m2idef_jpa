package com.m2i.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m2i.dao.DaoDeviseJpa;
import com.m2i.entity.Devise;

public class TestDaoDevise {
	
	//version sans Spring
	public static void main(String[] args) {
		//1. créer l'objet technique EntityManagerFactory de JPA 
		//en analysant le fichier META-INF/persistence.xml
		EntityManagerFactory entityManagerFactory =
				 Persistence.createEntityManagerFactory("myPersistenceUnitName");
		//myPersistenceUnitName est un nom logique d'une partie de la 
		//configuration de META-INF/persistence.xml
		
		//2. créer le EntityManager via la factory
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//3. créer le DaoDeviseJpa et appeler .setEntityManager()
		DaoDeviseJpa dao = new DaoDeviseJpa();
		dao.setEntityManager(entityManager);
		
		//4. appeler et tester des méthodes sur le DAO
		Devise d = new Devise();
		d.setCodeDevise("EUR"); d.setMonnaie("euro"); d.setChange(1.1);
		dao.insertDevise(d);
		Devise dRelu = dao.findDeviseByCode("EUR");
		System.out.println(dRelu.toString()); //avec toString() bien codé sur Devise
		List<Devise> listeDev = dao.findAllDevise();
		for(Devise dev : listeDev){
			System.out.println("\t"+dev);
		}
		
		//5. fermer le EntityManager
		entityManager.close();
		
		//6. Fermer le EntityManagerFactory
		entityManagerFactory.close();
	}

}
