package org.gcl.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CommandeProduit_Id implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_commande")
	private Commande commande;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_produit")
	private Produit produit;
	
	         //Constructor
	public CommandeProduit_Id() {
		super();
	}
	
	        //Getters and Setters
	
	public Commande getCommande() {
		return commande;
	}
	
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	    
	
	
}
