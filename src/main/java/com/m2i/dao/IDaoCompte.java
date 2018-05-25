package com.m2i.dao;

import java.util.List;

import com.m2i.entity.Compte;

/*
 * interface d'un DAO = Data Access Object
 * avec methodes CRUD
 * et throws RuntimeException implicites
 * sachant que JPAException hérite de RuntimeException
 */

public interface IDaoCompte {
    public Compte findCompteByNumero(Long numero);
    public List<Compte> findAllCompte();
    public void insertCompte(Compte d);
    public void updateCompte(Compte d);
    public void deleteCompte(Long numero);
    
    //a coder avec une namedQuery basee sur FROM Compte ...
    public List<Compte> comptesDuClient(Long numCli);
}
