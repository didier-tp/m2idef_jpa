package com.m2i.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.dao.IDaoDevise;
import com.m2i.entity.Devise;

/*
 * classe de Test gérée par Spring+JUnit4
 * nécessitant junit4.12 et spring-test dans pom.xml
 * à lancer sous eclipse via run as / junit test 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/beans.xml")
public class TestDaoDevise {
	@Autowired
	private IDaoDevise dao; //à tester
	
	@Test
	public void testDao(){
		Devise d = new Devise();
		d.setCodeDevise("EUR"); d.setMonnaie("euro"); d.setChange(1.1);
		dao.insertDevise(d);
		Devise dRelu = dao.findDeviseByCode("EUR");
		System.out.println(dRelu.toString()); //avec toString() bien codé sur Devise
		List<Devise> listeDev = dao.findAllDevise();
		for(Devise dev : listeDev){
			System.out.println("\t"+dev);
		}
	}
	
	
}
