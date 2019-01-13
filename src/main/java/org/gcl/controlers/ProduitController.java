package org.gcl.controlers;

import java.util.List;

import org.gcl.dao.ProduitRepository;
import org.gcl.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping("/produits")
	public List<Produit> getProduits(){
		return this.produitRepository.findAll();
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
	public Produit getProduit(@PathVariable int id) {
		return this.produitRepository.getOne(id);
	}
	
	@RequestMapping(value="/produits",method=RequestMethod.DELETE)
	public int delProduit(@PathVariable int id) {
		this.produitRepository.deleteById(id);
		return id;
	}
	
	@RequestMapping(value="/produits",method=RequestMethod.POST)
	public int addProduit(@RequestBody Produit produit) {
		this.produitRepository.save(produit);
		return produit.getId();
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.PUT)
	public Produit updateProduit(@PathVariable int id,@RequestBody Produit p) {
		p.setId(id);
	    return this.produitRepository.save(p);
	}
}
