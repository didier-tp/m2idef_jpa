package com.m2i.service;

import com.m2i.entity.Client;

public interface IServiceClient {
    public Client rechercherClientSelonNumero(Long numero);
    //...
    public void augmenterSalaires(double pourcentage);
}
