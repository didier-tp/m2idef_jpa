package com.m2i.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoClient;
import com.m2i.entity.Client;

@Service //spring (héritant de @Component)
@Transactional//version spring
public class ServiceClientImpl implements IServiceClient {
	@Autowired
	private IDaoClient daoClient;

	public Client rechercherClientSelonNumero(Long numero) {
		return daoClient.findClientByNumero(numero);
	}

	public void augmenterSalaires(double pourcentage) {
		//en début de méthode: initialisation entityManager
		//et entityManager.getTransaction().begin() automatique
		List<Client> listeClientsPersistants = daoClient.findAllClient();
		for(Client cli : listeClientsPersistants){
			if(cli.getSalaire()!=null)
			   cli.setSalaire(cli.getSalaire() * (1 + pourcentage / 100));
		}
        //en fin de méthode (sans exception):
		//entityManager.getTransaction().commit()
		//et entityManager.close() automatiques
		//le .commit() declenche automatiquement .flush() qui 
		//stocke en base (via update SQL) tous les objets persistants modifiés en mémoire
	}

}
