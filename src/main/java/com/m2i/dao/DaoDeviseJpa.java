package com.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import com.m2i.entity.Devise;

public class DaoDeviseJpa implements IDaoDevise {
	//@PersistenceContext (avec Spring ou EJB3)
	private EntityManager entityManager;
	
    //pour version sans spring
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Devise findDeviseByCode(String code) {
		return entityManager.find(Devise.class, code /*id/pk*/);
	}

	@Override
	public List<Devise> findAllDevise() {
		return null;
	}

	@Override
	public void insertDevise(Devise d) {
		try {
			entityManager.getTransaction().begin();
				entityManager.persist(d); //insert into ...
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void updateDevise(Devise d) {
		try {
			entityManager.getTransaction().begin();
				entityManager.merge(d); //insert into ...
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDevise(String code) {
		try {
			entityManager.getTransaction().begin();
				Devise d = entityManager.find(Devise.class, code);
				entityManager.remove(d);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

}
