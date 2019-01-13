package org.gcl.dao;

import org.gcl.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Integer>{

}
