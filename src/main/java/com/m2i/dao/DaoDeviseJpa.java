package com.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.m2i.entity.Devise;

@Transactional //en version spring
//NB: via @Transactional toutes les méthodes appelées sur cette classe
//auront un try/catch avec entityMananager.getTransaction().begin()
//                     et entityMananager.getTransaction().commit() ou .rollback()
public class DaoDeviseJpa implements IDaoDevise {
	
	@PersistenceContext(unitName="myPersistenceUnitName") //(avec Spring ou EJB3)
	//NB: @PersistenceContext est ici plus adpaté que @Autowired
	//car ça tient compte de META-INF/persitence.xml (ou équivalent)
	private EntityManager entityManager;
	
    //indispensable pour ancienne version sans spring
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Devise findDeviseByCode(String code) {
		return entityManager.find(Devise.class, code /*id/pk*/);
	}

	@Override
	public List<Devise> findAllDevise() {
		return entityManager.createQuery("SELECT d FROM Devise d",Devise.class)
				.getResultList();
	}

	@Override
	public void insertDevise(Devise d) {
			entityManager.persist(d); //insert into ...
	}

	@Override
	public void updateDevise(Devise d) {
		entityManager.merge(d); //update ...
	}

	@Override
	public void deleteDevise(String code) {
		Devise d = entityManager.find(Devise.class, code);
		entityManager.remove(d);//delete SQL
	}

}
