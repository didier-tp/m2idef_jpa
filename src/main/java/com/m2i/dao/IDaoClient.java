package com.m2i.dao;

import java.util.List;

import com.m2i.entity.Client;

/*
 * interface d'un DAO = Data Access Object
 * avec methodes CRUD
 * et throws RuntimeException implicites
 * sachant que JPAException hérite de RuntimeException
 */

public interface IDaoClient {
    public Client findClientByNumero(Long numero);
    public List<Client> findAllClient();
    public void insertClient(Client d);
    public void updateClient(Client d);
    public void deleteClient(Long numero);
}
