package com.m2i.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="Operation")  
public class Operation {
	@Id
	//...
	private Long id;
	
	private Double montant; 
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String label;
	
	//ManyToOne + JoinColumn (et dans le sens inverse @OneToMany(mappedBy="compte"))
	private Compte compte;
}
