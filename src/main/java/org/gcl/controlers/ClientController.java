package org.gcl.controlers;

import java.util.List;

import org.gcl.dao.ClientRepository;
import org.gcl.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping("/clients")
	public List<Client> getClients(){
		 
		return clientRepository.findAll();
	}
	
	@RequestMapping(value="/clients/{id}",method=RequestMethod.GET)
	public Client getClient(@PathVariable int id) {
		return this.clientRepository.getOne(id);
	}
	
	@RequestMapping(value="/clients/{id}",method=RequestMethod.DELETE )
	public int  delClient(@PathVariable int  id) {
		 this.clientRepository.deleteById(id);
		 return id;
	}
	
	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public int  addClient(@RequestBody Client client) {
		this.clientRepository.save(client);
		return client.getId();
	}
	
	@RequestMapping(value="/clients/{id}",method=RequestMethod.PUT)
	public Client updateClient(@PathVariable int id,@RequestBody Client cl) {
		cl.setId(id);
	    return this.clientRepository.save(cl);
	    
	}

}
