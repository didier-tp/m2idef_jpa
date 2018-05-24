package com.m2i.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// javax.persistence. = JPA
/*
 * classe d'entité persitante prise en charge par JPA/Hibernate
 */

@Entity
@Table(name="Client")
public class Client {
	
	@Id//clef primaire
	@GeneratedValue(strategy=GenerationType.IDENTITY) //pour auto_incr 
	private Long numero;//  "EUR" , "USD" , ...
	
	@Column(length=32)//VARCHAR(32)
	private String nom; 
	
	@Column(length=32)//VARCHAR(32)
	private String prenom;
	
	//salaire d'un client (ou employe)
	private Double salaire; //avec get/set
	


	public Client() {
	//default constructor
	}


	


	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom 
				   + ", salaire=" + salaire + "]";
	}





	public Long getNumero() {
		return numero;
	}


	public void setNumero(Long numero) {
		this.numero = numero;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Double getSalaire() {
		return salaire;
	}


	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

}
