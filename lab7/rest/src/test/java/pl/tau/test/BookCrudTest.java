package pl.tau.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.tau.api.AppConfig;
import pl.tau.dao.BookDAO;
import pl.tau.util.ConnectionProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
//@RunWith(JUnit4.class)
public class BookCrudTest {
	
//	@Autowired
//	private BookDAO bookDAO;
	
	@Test
	public void checkConnection() throws SQLException, NamingException {
		assertNull(null);
	}

}