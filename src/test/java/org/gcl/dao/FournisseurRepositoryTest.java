package org.gcl.dao;

import static org.junit.Assert.assertThat;

import org.gcl.entities.Fournisseur;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class FournisseurRepositoryTest {

	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private FournisseurRepository repository;
	
	
	@Test
	public void testFindByEmail() {
		
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setEmail("test@test.fr");
		entityManager.persist(fournisseur);
		
		Fournisseur fournisseurTrouve = this.repository.findByEmail("test@test.fr");
		
		assertThat(fournisseurTrouve.getEmail(), Matchers.is(Matchers.equalTo("test@test.fr")));
		
		
	}
	
	
}
