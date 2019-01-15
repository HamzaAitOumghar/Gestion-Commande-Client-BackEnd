package org.gcl.dao;

import static org.junit.Assert.assertEquals;

import org.gcl.entities.Client;
import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class ClientDaoTest {

	@Mock
	private ClientRepository clientRepo;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testAddClient() {
		
		Client client = new Client();
		
		client.setEmail("test@test.fr");
		client.setNom("test");
		
		Mockito.when(this.clientRepo.save(Mockito.any(Client.class))).thenReturn(client);
		
		Client client2 = this.clientRepo.save(new Client());
		
		assertEquals("test@test.fr",client2.getEmail());
		
	}
	
	
	
	
	
	
}
