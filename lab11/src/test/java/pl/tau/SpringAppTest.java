package pl.tau;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.tau.dao.ClientDao;
import pl.tau.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class})
public class SpringAppTest {
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@Autowired
	private ClientDao clientDao;
	
	
	@Test
	public void saveClientTest() {
		Client client = new Client("Jan", "Kowalski", "Krakowskie przedmiescie 23, Warszawa");
	    clientDao.save(client);
	}

}
