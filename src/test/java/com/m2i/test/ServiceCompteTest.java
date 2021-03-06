package com.m2i.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.service.IServiceCompte;

/*
 * classe de Test gérée par Spring+JUnit4
 * nécessitant junit4.12 et spring-test dans pom.xml
 * à lancer sous eclipse via run as / junit test 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class ServiceCompteTest {
	
	private static Logger logger = LoggerFactory.getLogger(ServiceCompteTest.class);
	
	@Autowired
	private IServiceCompte service; //à tester
	
	@Test
	public void testBonVirement(){
		Double solde1Avant = service.rechercherCompteSelonNum(1L).getSolde();
		Double solde2Avant = service.rechercherCompteSelonNum(2L).getSolde();
		logger.debug("avant bon virement: solde1="+solde1Avant + ",solde2=" + solde2Avant);
		service.effectuerVirement(1L, 2L, 50.0);
		Double solde1Apres = service.rechercherCompteSelonNum(1L).getSolde();
		Double solde2Apres = service.rechercherCompteSelonNum(2L).getSolde();
		logger.debug("apres bon virement: solde1="+solde1Apres + ",solde2=" + solde2Apres);
	    Assert.assertEquals(solde1Avant - 50,solde1Apres,0.00001);
	    Assert.assertEquals(solde2Avant + 50,solde2Apres,0.00001);
	}
	
	@Test
	public void testMauvaisVirement(){
		Double solde1Avant = service.rechercherCompteSelonNum(1L).getSolde();
		Double solde2Avant = service.rechercherCompteSelonNum(2L).getSolde();
		logger.debug("avant mauvais virement: solde1="+solde1Avant + ",solde2=" + solde2Avant);
		try {
			service.effectuerVirement(1L, -2L, 50.0);
			Assert.fail("une exception aurait du remonter");
		} catch (Exception e) {
			logger.debug("virement erroné avec numCptCred=-2 inexistant");
		}
		Double solde1Apres = service.rechercherCompteSelonNum(1L).getSolde();
		Double solde2Apres = service.rechercherCompteSelonNum(2L).getSolde();
		logger.debug("apres mauvais virement: solde1="+solde1Apres + ",solde2=" + solde2Apres);
		Assert.assertEquals(solde1Avant - 0,solde1Apres,0.00001);//rien doit changer en base
	    Assert.assertEquals(solde2Avant + 0,solde2Apres,0.00001);//si rollback
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
