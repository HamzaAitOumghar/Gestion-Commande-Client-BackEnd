package org.gcl.controlers;

import java.util.List;

import org.gcl.dao.CategorieProd_Repository;
import org.gcl.entities.CategorieProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieProd_Controller {
    
	@Autowired
	private CategorieProd_Repository categoryRepository;
	
	@RequestMapping("/categories")
    public List<CategorieProduit> getCategories(){
	   return this.categoryRepository.findAll();
    }
	
	@RequestMapping(value="/categories/{id}",method=RequestMethod.GET)
	public CategorieProduit getCategorie(@PathVariable int id) {
		return this.categoryRepository.getOne(id);
	}
	
	@RequestMapping(value="/categories/{id}",method=RequestMethod.DELETE)
	public int delCategorie(@PathVariable int id) {
		this.categoryRepository.deleteById(id);
		return id;
	}
	
	@RequestMapping(value="/categories/{id}",method=RequestMethod.PUT)
	public CategorieProduit  updateCategorie(@PathVariable int id,@RequestBody CategorieProduit cat) {
		cat.setId(id);
		return this.categoryRepository.save(cat);
	}
	
	@RequestMapping(value="/categories",method=RequestMethod.POST)
	public int addCategorie(@RequestBody CategorieProduit category) {
		 this.categoryRepository.save(category);
		 return category.getId();
	}
}
