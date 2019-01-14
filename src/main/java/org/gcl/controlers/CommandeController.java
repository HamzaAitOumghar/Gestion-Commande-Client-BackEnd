package org.gcl.controlers;

import java.util.List;

import org.gcl.dao.CommandeRepository;
import org.gcl.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommandeController {
    
	@Autowired
	private CommandeRepository commandeRepository;
	
	@RequestMapping("/commandes")
	public List<Commande> getCommands() {
		return this.commandeRepository.findAll();
	}
	
	@RequestMapping(value="/commandes/{id}",method=RequestMethod.GET)
	public Commande getCommande(@PathVariable int id) {
		return this.commandeRepository.getOne(id);
	}
	
	@RequestMapping(value="/Commandes/{id}",method=RequestMethod.DELETE)
	public int delCommande(@PathVariable int id) {
		this.commandeRepository.deleteById(id);
		return id;
	}
	
	@RequestMapping(value="/commandes",method=RequestMethod.POST)
	public int  addCommande(@RequestBody Commande commande) {
		this.commandeRepository.save(commande);
		return commande.getId();
	}
	
	@RequestMapping(value="/commandes/{id}",method=RequestMethod.PUT)
	public Commande updateCommande(@PathVariable int id ,@RequestBody Commande commande ) {
		commande.setId(id);
		return this.commandeRepository.save(commande);
		
	}
}
