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
		/*
		//solution 1 moyenne:
		Client cli= entityManager.find(Client.class, numero );
		for(Compte c : cli.getListeComptes()){} //pour remonter tout de suite en mémoire
		                                        //les éléments de la collection en mode LAZY
		return cli;
		*/
		//solution 2:
		return entityManager.createQuery(
			"SELECT c FROM Client c INNER JOIN FETCH c.listeComptes WHERE c.numero = :numCli"
				             , Client.class)
							.setParameter("numCli", numero)
				            .getSingleResult();
		//NB: la partie "INNER JOIN FETCH c.listeComptes" de la requete
		//demande à remonter TOUT DE SUITE (meme en mode LAZY) via le mot clef FETCH
		//les éléments de la collection des comptes rattachés au client
		//par une jointure (déjà paramétrée par le @OneToMany) 
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
