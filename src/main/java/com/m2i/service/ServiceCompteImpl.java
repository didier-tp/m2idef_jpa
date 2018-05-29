package com.m2i.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoCompte;
import com.m2i.entity.Compte;
import com.m2i.test.TestServiceCompte;

@Service
public class ServiceCompteImpl implements IServiceCompte {
	@Autowired
	private IDaoCompte daoCompte;
	private static Logger logger = LoggerFactory.getLogger(ServiceCompteImpl.class);

	@Override
	@Transactional() //à tester avec ou sans @Transactional
	public void effectuerVirement(Long numCptDeb, Long numCptCred, Double montant) {
		try {
			String labelOp = "virement de " + montant + " du compte " + numCptDeb +  " vers compte " + numCptCred ;
			Compte cptDeb = daoCompte.findCompteByNumero(numCptDeb);
			//cptDeb.setSolde(cptDeb.getSolde() - montant);
			cptDeb.debiter(montant,"debit suite a " + labelOp);
			if(cptDeb.getSolde() < 0)
				throw new RuntimeException("virement inderdit car compte à decouvert");
			//daoCompte.updateCompte(cptDeb); //inutile dans version avec @Transactional

			Compte cptCred = daoCompte.findCompteByNumero(numCptCred);
			cptCred.crediter(montant,"credit suite a " + labelOp);
			//cptCred.setSolde(cptCred.getSolde() + montant);
			//daoCompte.updateCompte(cptCred); //inutile dans version avec @Transactional
		} catch (Exception e) {
			logger.error("echec virement",e);
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
