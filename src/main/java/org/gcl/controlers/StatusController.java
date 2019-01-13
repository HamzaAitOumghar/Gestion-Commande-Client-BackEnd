package org.gcl.controlers;

import java.util.List;

import org.gcl.dao.StatusRepository;
import org.gcl.entities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
     
	@Autowired
	 private StatusRepository statusRepository;
	 
	@RequestMapping("/status")
	public List<Status> getStatusList(){
		return this.statusRepository.findAll();
	}
	
	@RequestMapping(value="/status/{id}",method=RequestMethod.GET)
	public Status getStatus(@PathVariable int id) {
		return this.statusRepository.getOne(id);
	}
	
	@RequestMapping(value="/status/{id}",method=RequestMethod.DELETE)
	public int delStatus(@PathVariable int id) {
		this.statusRepository.deleteById(id);
		return id;
	}
	
	@RequestMapping(value="/status",method=RequestMethod.POST)
	public int addStatus(@RequestBody Status status) {
		 this.statusRepository.save(status);
		 return status.getId();
	}
	
	@RequestMapping(value="/status/{id}",method=RequestMethod.PUT)
	public Status updateStatus(@PathVariable int id,@RequestBody Status s) {
		s.setId(id);
		return this.statusRepository.save(s);
		
	}
}
