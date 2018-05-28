package com.m2i.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PEL")
//avec dans super classe "Compte":
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="typeCompte",discriminatorType=DiscriminatorType.STRING)
public class ComptePEL extends Compte {
	private Double tauxInteret; //en %
	private Double apportMensuel;

	public Double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
	

	public Double getApportMensuel() {
		return apportMensuel;
	}

	public void setApportMensuel(Double apportMensuel) {
		this.apportMensuel = apportMensuel;
	}

	@Override
	public String toString() {
		return "ComptePEL [tauxInteret=" + tauxInteret + ",apportMensuel=" + apportMensuel + "]"
				+ " heritant de " + super.toString();
	}
	
	

}
