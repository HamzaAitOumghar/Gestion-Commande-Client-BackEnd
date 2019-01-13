package org.gcl.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Status {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id_status")
	private int id;
	@Column
	private String libelleStatus;
	
	@OneToMany(mappedBy="status")
	private List<Commande> commandes;
	    
	       //Constructor
	public Status() {
		super();
	}
           //Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelleStatus() {
		return libelleStatus;
	}

	public void setLibelleStatus(String libelleStatus) {
		this.libelleStatus = libelleStatus;
	}
	
}
