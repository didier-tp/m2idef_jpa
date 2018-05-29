package com.m2i.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m2i.dao.IDaoDevise;
import com.m2i.entity.Devise;
import com.m2i.entity.Pays;

/*
 * classe de Test gérée par JUnit4
 * nécessitant junit4.12  dans pom.xml
 * à lancer sous eclipse via run as / junit test 
 */

public class TestDaoDeviseVariantePedagogique {
	private static ClassPathXmlApplicationContext springContext; 
	private IDaoDevise dao; //à tester
	
	@BeforeClass
	public static void initContext(){
		//initialiser le contexte spring via config xml
				springContext = 
						new ClassPathXmlApplicationContext("/beans.xml");
	}
	
	@Before
	public void init(){
		this.dao = springContext.getBean(IDaoDevise.class);
	}
	
	@AfterClass
	public static void fin(){
		springContext.close();
	}
	
	@Test
	public void testPays(){
		Devise deviseEuro = dao.findDeviseByCode("EUR");
		System.out.println("deviseEuro"+ deviseEuro);
		for(Pays p : deviseEuro.getListePays()){
			System.out.println("\t"+ p);
		}
	}
	
	@Test
	public void testDao(){
		Devise d = new Devise();
		d.setCodeDevise("EUR2"); d.setMonnaie("euro2"); d.setChange(1.1);
		dao.insertDevise(d);
		Devise dRelu = dao.findDeviseByCode("EUR2");
		System.out.println(dRelu.toString()); //avec toString() bien codé sur Devise
		List<Devise> listeDev = dao.findAllDevise();
		for(Devise dev : listeDev){
			System.out.println("\t"+dev);
		}
	}
	
	
}
