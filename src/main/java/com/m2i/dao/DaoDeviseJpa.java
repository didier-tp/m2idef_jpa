package com.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.m2i.entity.Devise;

public class DaoDeviseJpa implements IDaoDevise {
	
	private EntityManager entityManager;

	@Override
	public Devise findDeviseByCode(String code) {
		return null;
	}

	@Override
	public List<Devise> findAllDevise() {
		return null;
	}

	@Override
	public void insertDevise(Devise d) {
	}

	@Override
	public void updateDevise(Devise d) {
	}

	@Override
	public void deleteDevise(String code) {
	}

}
