package com.m2i.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCompte",discriminatorType=DiscriminatorType.STRING )
@DiscriminatorValue("COURANT") //compte courant par defaut
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
	
	@OneToMany(mappedBy="compte", fetch=FetchType.LAZY , cascade =CascadeType.ALL)
	private List<Operation> listeOperations; //avec get/set


	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
	public void debiter(double montant){
		this.debiter(montant,"debit");
	}
	public void debiter(double montant,String label){
		this.setSolde(this.getSolde()-montant);
		Operation opDebit = new Operation();
		opDebit.setLabel(label);
		opDebit.setDate(new Date());
		opDebit.setMontant(-montant);
		opDebit.setCompte(this);
		this.getListeOperations().add(opDebit);
	}
	
	public void crediter(double montant){
	    this.crediter(montant,"credit");
	}
	
	public void crediter(double montant,String label){
		this.setSolde(this.getSolde()+montant);
		Operation opCredit = new Operation();
		opCredit.setLabel(label);
		opCredit.setDate(new Date());
		opCredit.setMontant(+montant);
		opCredit.setCompte(this);
		this.getListeOperations().add(opCredit);
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
