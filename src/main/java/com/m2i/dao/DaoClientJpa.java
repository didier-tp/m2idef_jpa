package com.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.entity.Client;
import com.m2i.entity.Compte;

@Component//(ou @Repository)de spring
@Transactional //en version spring
//NB: via @Transactional toutes les méthodes appelées sur cette classe
//auront un try/catch avec entityMananager.getTransaction().begin()
//                     et entityMananager.getTransaction().commit() ou .rollback()
public class DaoClientJpa implements IDaoClient {
	
	@PersistenceContext(unitName="myPersistenceUnitName") //(avec Spring ou EJB3)
	//NB: @PersistenceContext est ici plus adpaté que @Autowired
	//car ça tient compte de META-INF/persistence.xml (ou équivalent)
	private EntityManager entityManager;
	
    

	@Override
	public Client findClientByNumero(Long numero) {
		return entityManager.find(Client.class, numero /*id/pk*/);
	}
	
	@Override
	public Client findClientWithComptesByNumero(Long numero) {
		Client cli= entityManager.find(Client.class, numero /*id/pk*/);
		for(Compte c : cli.getListeComptes()){} //pour remonter tout de suite en mémoire
		                                        //les éléments de la collection en mode LAZY
		return cli;
	}

	@Override
	public List<Client> findAllClient() {
		return entityManager.createQuery("SELECT c FROM Client c",Client.class)
				.getResultList();
	}

	@Override
	public void insertClient(Client c) {
			entityManager.persist(c); //insert into ...
	}

	@Override
	public void updateClient(Client c) {
		entityManager.merge(c); //update ...
	}

	@Override
	public void deleteClient(Long numero) {
		Client c = entityManager.find(Client.class, numero);
		entityManager.remove(c);//delete SQL
	}

}
