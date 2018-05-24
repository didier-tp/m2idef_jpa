package com.m2i.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.dao.IDaoClient;
import com.m2i.entity.Client;
import com.m2i.entity.Compte;

/*
 * classe de Test gérée par Spring+JUnit4
 * nécessitant junit4.12 et spring-test dans pom.xml
 * à lancer sous eclipse via run as / junit test 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestDaoClient {
	@Autowired
	private IDaoClient dao; //à tester
	
	@Test
	public void testDao(){
		Client c = new Client();
		//NB: avant insert/persist le numero du client est inconnu (à null)
		c.setPrenom("alex"); c.setNom("Therieur"); 
		dao.insertClient(c);
		//NB: apres insert/persist le numero du client est connu (auto_incr)
		//avec @GeneratedValue(strategy=GenerationType.IDENTITY)
		Long numero = c.getNumero();
		Client cRelu = dao.findClientByNumero(numero);
		System.out.println(cRelu.toString()); //avec toString() bien codé sur Client
		List<Client> listeClient = dao.findAllClient();
		for(Client cli : listeClient){
			System.out.println("\t"+cli);
		}
	}
	
	@Test
	public void testComptes(){
		Client c1 = dao.findClientByNumero(1L);
		System.out.println("c1= "+ c1);
		for(Compte c : c1.getListeComptes()){
			System.out.println("\t"+ c);
		}
	}
	
	/*
	 Remarque importante: 
	 ===================
	 dès que le "entityManager" est fermé (ce qui est automatiquement déclenché par Spring
	 au sein des méthodes marquées via @Transactional dans les services et/ou dao )
	 tous les objets persistants passent à l'état détachés.
	 ==> coté Test et coté Web , tous les objets sont détachés de JPA/Hibernate !!!
	 */
	
	@Test
	public void testCRUD(){
		//1a.ajout
		Client c = new Client();
		c.setPrenom("olie"); c.setNom("Condor"); 
		dao.insertClient(c);
		Long numero = c.getNumero();
		//1b. verif ajout via relecture
		Client cRelu = dao.findClientByNumero(numero);
		System.out.println(cRelu.toString()); 
		Assert.assertTrue(cRelu.getPrenom().equals("olie"));
		//2b. update
		c.setPrenom("**nouveauPrenom**");
		dao.updateClient(c);
		//2c. verif mise à jour via relecture
		cRelu = dao.findClientByNumero(numero);
		Assert.assertTrue(cRelu.getPrenom().equals("**nouveauPrenom**"));
		System.out.println(cRelu.toString()); 
		//3a. suppression
		dao.deleteClient(numero);
		//3b. verif suppression
		cRelu=dao.findClientByNumero(numero);
		Assert.assertTrue(cRelu==null);
		System.out.println("cRelu normalement null="+cRelu);
	}
}
