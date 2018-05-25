package com.m2i.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Client;
import com.m2i.service.IServiceCompte;

/*
 * classe de Test gérée par Spring+JUnit4
 * nécessitant junit4.12 et spring-test dans pom.xml
 * à lancer sous eclipse via run as / junit test 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestServiceCompte {
	@Autowired
	private IServiceCompte service; //à tester
	
	@Test
	public void testBonVirement(){
		Double solde1 = service.rechercherCompteSelonNum(1L).getSolde();
		Double solde2 = service.rechercherCompteSelonNum(2L).getSolde();
		System.out.println("avant bon virement: solde1="+solde1 + ",solde2=" + solde2);
		service.effectuerVirement(1L, 2L, 50.0);
		solde1 = service.rechercherCompteSelonNum(1L).getSolde();
		solde2 = service.rechercherCompteSelonNum(2L).getSolde();
		System.out.println("apres bon virement: solde1="+solde1 + ",solde2=" + solde2);
	}
	
	@Test
	public void testMauvaisVirement(){
		Double solde1 = service.rechercherCompteSelonNum(1L).getSolde();
		Double solde2 = service.rechercherCompteSelonNum(2L).getSolde();
		System.out.println("avant mauvais virement: solde1="+solde1 + ",solde2=" + solde2);
		try {
			service.effectuerVirement(1L, -2L, 50.0);
		} catch (Exception e) {
			System.err.println("virement erroné avec numCptCred=-2 inexistant");
		}
		solde1 = service.rechercherCompteSelonNum(1L).getSolde();
		solde2 = service.rechercherCompteSelonNum(2L).getSolde();
		System.out.println("apres mauvais virement: solde1="+solde1 + ",solde2=" + solde2);
	}
	
	/*
	 Remarque importante: 
	 ===================
	 dès que le "entityManager" est fermé (ce qui est automatiquement déclenché par Spring
	 au sein des méthodes marquées via @Transactional dans les services et/ou dao )
	 tous les objets persistants passent à l'état détachés.
	 ==> coté Test et coté Web , tous les objets sont détachés de JPA/Hibernate !!!
	 */
	
	
}
