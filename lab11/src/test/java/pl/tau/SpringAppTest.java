package pl.tau;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.tau.dao.ClientDao;
import pl.tau.dao.OrderDao;
import pl.tau.model.Client;
import pl.tau.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class})
public class SpringAppTest {
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@Autowired
	private ClientDao clientDao;
	@Autowired
	OrderDao orderDao;
	
	
	@Test
	public void saveClientTest() {
		Client client = new Client("Krystian", "Nowacki", "Gdansk Wolnosci 22/1");
	    clientDao.save(client);
	    Order order = new Order("MSI Notebook", "kurier");
	    order.setClient(client);
	    orderDao.save(order);
	}
	
	@Test
	public void removeClientTest() {
		Client client2 = new Client("Marcin", "Kowalski", "Krakowskie przedmiescie 23, Warszawa");
	    clientDao.save(client2);
	    clientDao.remove(client2.getId());
	}
	
	@Test
	public void updateClientTest() {
		Client client3 = new Client("Bartek", "Kowalski", "Wilanowskie pola 223, Bydgodszcz");
	    clientDao.save(client3);
	    Client client4 = new Client("Michal", "Kowalski", "Wilanowskie pola 223, Bydgodszcz");
	    client4.setId(client3.getId());
	    clientDao.update(client4);
	     
	    
	}
	


}
