package org.gcl.dao;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.gcl.entities.Commande;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandeDaoTest {

	@Autowired
	private CommandeRepository commandeRepo;
	
	
	@Test
	public void addCommande() {
		
		Date currentDate = new Date();
		Commande cmd =new Commande();
		cmd.setDateCommande(new java.sql.Date(currentDate.getTime()));
		cmd.setDateLivraison(new java.sql.Date(currentDate.getTime()));
		cmd.setNumero("CM120");
		
		Commande commande = commandeRepo.save(cmd);
		
		//Test
		
		assertNotNull(commande);
		assertNotNull(commande.getId());
		assertEquals("CM120", commande.getNumero());
		
		
	}
	
}
