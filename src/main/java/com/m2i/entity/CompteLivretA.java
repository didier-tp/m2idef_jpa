package com.m2i.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LivretA")
//avec dans super classe "Compte":
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="typeCompte",discriminatorType=DiscriminatorType.STRING)
public class CompteLivretA extends Compte {
	private Double tauxInteret; //en %

	public Double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	@Override
	public String toString() {
		return "CompteLivretA [tauxInteret=" + tauxInteret + "]"
				+ " heritant de " + super.toString();
	}
	
	

}
