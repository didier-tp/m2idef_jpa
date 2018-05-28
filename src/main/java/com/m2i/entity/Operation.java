package com.m2i.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="Operation")  
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Double montant; 
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String label;
	
	//ManyToOne + JoinColumn (et dans le sens inverse @OneToMany(mappedBy="compte"))
	@ManyToOne
	@JoinColumn(name="compte") 
	private Compte compte;
	
	

	@Override
	public String toString() {
		return "Operation [id=" + id + ", montant=" + montant + ", date=" + date + ", label=" + label + "]";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Double getMontant() {
		return montant;
	}



	public void setMontant(Double montant) {
		this.montant = montant;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}
