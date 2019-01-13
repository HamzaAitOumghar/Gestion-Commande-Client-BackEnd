package org.gcl.entities;

import java.sql.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      @Column(name="id_commande")
	 private int id;
     @Column
	 private String numero;
     @Column
	 private Date dateCommande;
     @Column
	 private Date datePaiment;
     @Column
	 private Date dateLivraison;
     
     @ManyToOne
     @JoinColumn(name="id_client")
     private Client client;
	
     @OneToMany(mappedBy="commandeProduit_id.commande")
     private List<Commande_Produit> quantites;
	 
     @ManyToOne
     @JoinColumn(name="id_status")
     private Status status;
	 
	    // Constructor
	 public Commande() {
			super();
		}
          // Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDatePaiment() {
		return datePaiment;
	}

	public void setDatePaiment(Date datePaiment) {
		this.datePaiment = datePaiment;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Commande_Produit> getQuantites() {
		return quantites;
	}

	public void setQuantites(List<Commande_Produit> quantites) {
		this.quantites = quantites;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	 
	
}
