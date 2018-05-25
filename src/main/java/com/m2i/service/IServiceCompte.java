package com.m2i.service;

import java.util.List;

import com.m2i.entity.Compte;

public interface IServiceCompte {
   public void effectuerVirement(Long numCptDeb,Long numCptCred,Double montant);
   public Compte rechercherCompteSelonNum(Long numCpt);
   public List<Compte> rechercherComptesDuClient(Long numClient);
   //...
}
