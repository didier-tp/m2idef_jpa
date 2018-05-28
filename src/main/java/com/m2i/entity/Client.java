package com.m2i.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
// javax.persistence. = JPA
/*
 * classe d'entité persitante prise en charge par JPA/Hibernate
 */

@Entity
@Table(name="Client")
@NamedQuery(name="Client.findByNumWithComptes",
   query="SELECT c FROM Client c INNER JOIN FETCH c.listeComptes WHERE c.numero = :numCli")
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
	
	//@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
    private List<Compte> listeComptes; //avec get/set

	@OneToOne(mappedBy="client")
	private Adresse adresse;//+get/set
	
	public Client() {
	//default constructor
	}



	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + "]";
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

	public List<Compte> getListeComptes() {
		return listeComptes;
	}


	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
}
