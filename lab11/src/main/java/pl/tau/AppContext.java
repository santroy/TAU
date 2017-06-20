package pl.tau;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.tau.dao.ClientDao;
import pl.tau.dao.OrderDao;
import pl.tau.model.Client;
import pl.tau.model.Order;



@Configuration
@ComponentScan
public class AppContext {
	public static void main(String[] args) throws InterruptedException {
	AnnotationConfigApplicationContext ctx = 
            new AnnotationConfigApplicationContext(AppContext.class);
	
	Client client = new Client("Krystian", "Nowacki", "Gdansk Wolnosci 22/1");
    ClientDao clientDao = ctx.getBean(ClientDao.class);
    clientDao.save(client);
    System.out.println(client);
     
    Order order = new Order("MSI Notebook", "kurier");
    order.setClient(client);
    OrderDao orderDao = ctx.getBean(OrderDao.class);
    orderDao.save(order);
    
    //orderDao.remove(1L);
    
    Client client2 = new Client("Marcin", "Kowalski", "Krakowskie przedmiescie 23, Warszawa");
    client2.setId(client.getId());
    
    clientDao.update(client2);
     
    ctx.close();
	}
}
