package org.gcl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commande_Produit {
	@Id
	private CommandeProduit_Id commandeProduit_id;
	private int quantite;
	
	    //Constructor
	public Commande_Produit() {
		super();
	}
	 //Getters  and Setters

	public CommandeProduit_Id getCommandeProduit_id() {
		return commandeProduit_id;
	}
	public void setCommandeProduit_id(CommandeProduit_Id commandeProduit_id) {
		this.commandeProduit_id = commandeProduit_id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
  
	public Commande getCommande() {
		return this.commandeProduit_id.getCommande();
	}
	
	public void setCommande(Commande commande) {
		this.commandeProduit_id.setCommande(commande);
	}
	
	public Produit getProduit() {
		return this.commandeProduit_id.getProduit();
	}
	public void setProduit(Produit produit) {
		this.commandeProduit_id.setProduit(produit);
	}

}
