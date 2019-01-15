package org.gcl.controller;

import java.util.ArrayList;
import java.util.List;


import org.gcl.controlers.ClientController;
import org.gcl.entities.Client;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {
	
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ClientController clientController;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetAllClients() throws Exception {
		
		Client client =new Client();
		client.setEmail("test@test.fr");
		client.setNom("test");
		
		Client client2 =new Client();
		client2.setEmail("test@test.fr");
		client2.setNom("test");

		
		List<Client> clients = new ArrayList<Client>();
		clients.add(client);
		clients.add(client2);
		
		
		Mockito.when(this.clientController.getClients()).thenReturn(clients);
		
		
		this.mvc.perform(MockMvcRequestBuilders.get("/clients"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)));
						
			
		
		
		
	}
	
	
	
}
