package com.m2i.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pays")
public class Pays {
	@Id
	private String codePays; //"fr", "es" , "de"
	
	private String nom; //France  , Allemagne , ....
	
	//...
	
	@ManyToOne
	@JoinColumn(name="devise")
	private Devise devise;
	
	

	@Override
	public String toString() {
		return "Pays [codePays=" + codePays + ", nom=" + nom + "]";
	}

	public String getCodePays() {
		return codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	
	
}
