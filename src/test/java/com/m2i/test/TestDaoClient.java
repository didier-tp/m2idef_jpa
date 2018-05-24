package com.m2i.test;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.dao.IDaoClient;
import com.m2i.entity.Client;
import com.m2i.entity.Devise;

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
}
