package org.gcl.entities;

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
public class Produit {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="id_produit")
	private int id;
    @Column
	private String libelleProduit;
    @Column
	private float prixProduit;
    
    @ManyToOne
    @JoinColumn(name="id_fournisseur")
    private Fournisseur fournisseur;
	
    @ManyToOne
    @JoinColumn(name="id_category")
    private CategorieProduit categorieProduit;
    
    @OneToMany(mappedBy="commandeProduit_id.produit")
    private List<Commande_Produit> quantites;
    
	     //Constructor
	public Produit() {
		super();
	}
	      //Getters and Setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelleProduit() {
		return libelleProduit;
	}
	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}
	public float getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
	public List<Commande_Produit> getQuantites() {
		return quantites;
	}
	public void setQuantites(List<Commande_Produit> quantites) {
		this.quantites = quantites;
	}
	
	    
	
	
}
