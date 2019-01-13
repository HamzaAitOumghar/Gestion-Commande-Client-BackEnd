package org.gcl.controlers;

import java.util.List;

import org.gcl.dao.FournisseurRepository;
import org.gcl.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FournisseurController {
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
   
	@RequestMapping("/fournisseurs")
	public List<Fournisseur> getFournissurs(){
		return this.fournisseurRepository.findAll();
	}
	
	@RequestMapping(value="/fournisseurs/{id}",method=RequestMethod.GET)
	public Fournisseur getFournissur(@PathVariable int id) {
		return this.fournisseurRepository.getOne(id);
	}
	
	@RequestMapping(value="/fournisseurs/{id}",method=RequestMethod.DELETE)
	public int delFournisseur(@PathVariable int id) {
		this.fournisseurRepository.deleteById(id);
		return id;
	}
	
	@RequestMapping(value="/fournisseurs/",method=RequestMethod.POST)
	public int addFournisseur(@RequestBody Fournisseur f) {
		this.fournisseurRepository.save(f);
		return f.getId();
	}
	
	@RequestMapping(value="/fournisseurs/{id}",method=RequestMethod.PUT)
	public Fournisseur updateFournisseur(@PathVariable int id,@RequestBody Fournisseur f) {
		f.setId(id);
		return this.fournisseurRepository.save(f);
	}
}
