package pl.tau.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
 
@Component
public class ConnectionProvider {
    private static DataSource dataSource;
     
    public static Connection getConnection() throws SQLException {
        return getDSInstance().getConnection();
    }
     
    public static DataSource getDSInstance() {
        if(dataSource == null) {  	
        	
			try {
				Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:comp/env");
				dataSource = (DataSource) envContext.lookup("jdbc/library");
			} catch (NamingException e) {
				e.printStackTrace();
			}
        }
        return dataSource;
    }
    
    public static Connection getConnectionTest() throws SQLException {
    	
    	return DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
    	
    	
    }
    
}