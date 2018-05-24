package com.m2i.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Client;
import com.m2i.service.IServiceClient;

/*
 * classe de Test gérée par Spring+JUnit4
 * nécessitant junit4.12 et spring-test dans pom.xml
 * à lancer sous eclipse via run as / junit test 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestServiceClient {
	@Autowired
	private IServiceClient service; //à tester
	
	@Test
	public void testAugmentation(){
		Client c1 = service.rechercherClientSelonNumero(1L);
		System.out.println("c1 avant augmentation:" + c1);
		service.augmenterSalaires(10);//10%
		Client c1ApresAugmentation = service.rechercherClientSelonNumero(1L);
		System.out.println("c1 apres augmentation:" + c1ApresAugmentation);
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
