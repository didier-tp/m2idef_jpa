package com.m2i.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// javax.persistence. = JPA
/*
 * classe d'entité persitante prise en charge par JPA/Hibernate
 */

@Entity
@Table(name="Devise")
public class Devise {
	@Column(length=6)//VARCHAR(6)
	@Id//clef primaire
	//@GeneratedValue(strategy=GenerationType.IDENTITY) pour auto_incr (impossible sur String)
	private String codeDevise;//  "EUR" , "USD" , ...
	
	@Column(length=64)//VARCHAR(64)
	private String monnaie; //"euro" , "dollar"
	
	@Column(nullable=true,name="dchange")
	private Double change; // change par rapport au dollar

	@OneToMany(mappedBy="devise",fetch=FetchType.EAGER)
	private List<Pays> listePays; //avec get/set
	
	public Devise() {
	//default constructor
	}
	
	

	@Override
	public String toString() {
		return "Devise [codeDevise=" + codeDevise + ", monnaie=" + monnaie + ", change=" + change + "]";
	}



	public String getCodeDevise() {
		return codeDevise;
	}

	public void setCodeDevise(String codeDevise) {
		this.codeDevise = codeDevise;
	}

	public String getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}



	public List<Pays> getListePays() {
		return listePays;
	}



	public void setListePays(List<Pays> listePays) {
		this.listePays = listePays;
	}
	
	
}
