package com.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.entity.Compte;
import com.m2i.entity.Operation;

@Component//(ou @Repository)de spring
@Transactional //en version spring
//NB: via @Transactional toutes les méthodes appelées sur cette classe
//auront un try/catch avec entityMananager.getTransaction().begin()
//                     et entityMananager.getTransaction().commit() ou .rollback()
public class DaoCompteJpa implements IDaoCompte {
	
	@PersistenceContext(unitName="myPersistenceUnitName") //(avec Spring ou EJB3)
	//NB: @PersistenceContext est ici plus adpaté que @Autowired
	//car ça tient compte de META-INF/persistence.xml (ou équivalent)
	private EntityManager entityManager;
	
    

	@Override
	public Compte findCompteByNumero(Long numero) {
		return entityManager.find(Compte.class, numero /*id/pk*/);
	}

	@Override
	public List<Compte> findAllCompte() {
		return entityManager.createQuery("SELECT c FROM Compte c",Compte.class)
				.getResultList();
	}

	@Override
	public void insertCompte(Compte c) {
			entityManager.persist(c); //insert into ...
	}

	@Override
	public void updateCompte(Compte c) {
		entityManager.merge(c); //update ...
	}

	@Override
	public void deleteCompte(Long numero) {
		Compte c = entityManager.find(Compte.class, numero);
		entityManager.remove(c);//delete SQL
	}

	@Override
	public List<Compte> comptesDuClient(Long numCli) {
		return entityManager.createNamedQuery(
				"Compte.findByNumCli" , Compte.class)
								.setParameter("numCli", numCli)
					            .getResultList();
	}

	@Override
	public List<Operation> operationsDuCompte(long numCpt) {
		return entityManager.createNamedQuery(
				"Compte.findOperationsByNumCompte" , Operation.class)
								.setParameter("numCpt", numCpt)
					            .getResultList();
	}

}
