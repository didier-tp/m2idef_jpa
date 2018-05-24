package com.m2i.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m2i.dao.IDaoDevise;
import com.m2i.entity.Devise;

public class TestDaoDeviseV1SansJunit {
	
	//version sans Spring
	public static void main(String[] args) {
		//1. initialiser le contexte spring via config xml
		ClassPathXmlApplicationContext springContext = 
				new ClassPathXmlApplicationContext("/beans.xml");
	
		//2. récupérer un access au DAO géré par Spring
		IDaoDevise dao = springContext.getBean(IDaoDevise.class);
		
		//3. appeler et tester des méthodes sur le DAO
		Devise d = new Devise();
		d.setCodeDevise("EUR"); d.setMonnaie("euro"); d.setChange(1.1);
		dao.insertDevise(d);
		Devise dRelu = dao.findDeviseByCode("EUR");
		System.out.println(dRelu.toString()); //avec toString() bien codé sur Devise
		List<Devise> listeDev = dao.findAllDevise();
		for(Devise dev : listeDev){
			System.out.println("\t"+dev);
		}
		
		//4. fermer le context spring
		springContext.close();
		
	}

}
