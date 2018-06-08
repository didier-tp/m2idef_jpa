package com.m2i.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity ou @Embeddable
@Entity 
@Table(name="Adresse")//au sens AdresseDuClient avec correspondance de pk
public class Adresse {

	@Id //pas de @GeneratedValue si correspondance de pk 
	private Long idAdresse; // si pas @Embeddable
	
	private String rue; //numero et rue
	
	@Column(length=12)
	private String codePostal ; 
	
	private String ville;
	//private String pays
	
	@OneToOne(optional=true)
	@PrimaryKeyJoinColumn
	private Client client; //avec get/set
	
	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
	public Long getIdAdresse() {
		return idAdresse;
	}
	
	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
	
}
