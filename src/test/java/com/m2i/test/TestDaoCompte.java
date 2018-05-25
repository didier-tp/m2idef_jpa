package com.m2i.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.dao.IDaoCompte;
import com.m2i.entity.Compte;
import com.m2i.entity.Compte;

/*
 * classe de Test gérée par Spring+JUnit4
 * nécessitant junit4.12 et spring-test dans pom.xml
 * à lancer sous eclipse via run as / junit test 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestDaoCompte {
	@Autowired
	private IDaoCompte dao; //à tester
	
	
	
	@Test
	public void testComptes(){
		//...
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
		Compte c = new Compte();
		c.setLabel("nouveau compte"); c.setSolde(10.0); 
		dao.insertCompte(c);
		Long numero = c.getNumero();
		//1b. verif ajout via relecture
		Compte cRelu = dao.findCompteByNumero(numero);
		System.out.println(cRelu.toString()); 
		Assert.assertTrue(cRelu.getLabel().equals("nouveau compte"));
		//2b. update
		c.setLabel("**nouveauLabelDuCompte**");
		dao.updateCompte(c);
		//2c. verif mise à jour via relecture
		cRelu = dao.findCompteByNumero(numero);
		Assert.assertTrue(cRelu.getLabel().equals("**nouveauLabelDuCompte**"));
		System.out.println(cRelu.toString()); 
		//3a. suppression
		dao.deleteCompte(numero);
		//3b. verif suppression
		cRelu=dao.findCompteByNumero(numero);
		Assert.assertTrue(cRelu==null);
		System.out.println("cRelu normalement null="+cRelu);
	}
}
