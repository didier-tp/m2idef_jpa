package com.m2i.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Compte")
@NamedQueries({
@NamedQuery(name="Compte.findByNumCli",
 query="SELECT cpt FROM Client cli INNER JOIN cli.listeComptes cpt WHERE cli.numero = :numCli") ,
@NamedQuery(name="Compte.findOperationsByNumCompte",
 query="SELECT op FROM Compte cpt INNER JOIN cpt.listeOperations op WHERE cpt.numero = :numCpt")
})
//old 1-n Compte.findByNumCli query : SELECT cpt FROM Compte cpt WHERE cpt.client.numero = :numCli
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	private String label;
	
	private Double solde;
	
	@ManyToMany 
	@JoinTable(name = "Compte_Client",   
	  joinColumns = {@JoinColumn(name = "numCpt")},                    
	  inverseJoinColumns = {@JoinColumn(name = "numCli")}) 
	private List<Client> listeClients; 
	
	@OneToMany(mappedBy="compte", fetch=FetchType.LAZY)
	private List<Operation> listeOperations; //avec get/set

		

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public List<Operation> getListeOperations() {
		return listeOperations;
	}

	public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;
	}
	
	

}
