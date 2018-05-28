package com.m2i.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoCompte;
import com.m2i.entity.Compte;

@Service
public class ServiceCompteImpl implements IServiceCompte {
	
	@Autowired
	private IDaoCompte daoCompte;

	@Override
	@Transactional() //à tester avec ou sans @Transactional
	//à tester avec effectuerVirement(1L, 2L, 50.0) , comptes 1L et 2L existants
	//à tester également avec effectuerVirement(1L, -2L, 50.0) , compte -2L inexistant
	public void effectuerVirement(Long numCptDeb, Long numCptCred, Double montant) {
		try {
			Compte cptDeb = daoCompte.findCompteByNumero(numCptDeb);
			cptDeb.setSolde(cptDeb.getSolde() - montant);
			if(cptDeb.getSolde() < 0)
				throw new RuntimeException("virement inderdit car compte à decouvert");
			//daoCompte.updateCompte(cptDeb); //inutile dans version avec @Transactional

			Compte cptCred = daoCompte.findCompteByNumero(numCptCred);
			cptCred.setSolde(cptCred.getSolde() + montant);
			//daoCompte.updateCompte(cptCred); //inutile dans version avec @Transactional
		} catch (Exception e) {
			//logger.error(...)
			throw new RuntimeException("echec virement",e);
		}
	}

	@Override
	public Compte rechercherCompteSelonNum(Long numCpt) {
		return daoCompte.findCompteByNumero(numCpt);
	}

	@Override
	public List<Compte> rechercherComptesDuClient(Long numClient) {
		return daoCompte.comptesDuClient(numClient);
	}

}
