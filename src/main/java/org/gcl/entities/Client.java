package org.gcl.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_client")
	private int id;
    @Column
	private String nom;
    @Column
	private String prenom;
    @Column
	private String email;
    @Column
	private String telephone;
   
    @OneToMany(mappedBy="client")
    @JsonIgnore
    private List<Commande> commandes;
	
	    // Constructor
	public Client() {
		super();
	}
	
	 public Client(String nom, String prenom, String email, String telephone) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.telephone = telephone;
    }

		// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	  
	
}
