package com.kdvamja.springjdbc;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kdvamja.springjdbc.dao.ClientDao;
import com.kdvamja.springjdbc.entity.Client;

/**
 * Spring JDBC
 * => Spring JDBC is a powerful mechanism to connect to the database and execute SQL queries
 * => it's internally use Java JDBC API's
 * => Spring JDBC module provide JdbcTemplate for use database operations
 * => JDBC is API to perform operation with Database.
 * 
 * Problems of JDBC
 * => We need to write a lot of code.
 * 		A) Connection open
 * 		b) statement
 * 		c) execute
 * 		d) connection close
 * => Exception Handling Problem: checked Exception (SQLException)
 * => Repeatation of all these codes from one to another database logic is a time consuming task.
 * 
 * Solution of JDBC Problems
 * => Spring JDBC provide class JdbcTemplate which has all the important methods to perform operation with database.
 * => JdbcTemplate needs DataSource to fire queries -> fire insert, update, delete, select
 * => DataSource is an interface and we have DriverManagerDataSource class which implements DataSource
 * => DriverManagerDataSource needs driverClassName, url, username, password
 *
 * RowMapper (Spring JDBC provides RowMapper interface, also Java Swing has RowMapper interface but here we talk about Spring JDBC)
 * => it is a interface which internally converts ResultSet to Object.
 * => it is functional interface.
 * T mapRow(ResultSet rs, int rowNum) throws SQLException
 */
public class App 
{
    private static ApplicationContext applCon;

	public static void main( String[] args ){
        System.out.println( "App :: main()" );
        applCon = new ClassPathXmlApplicationContext("com/kdvamja/springjdbc/config/application-config.xml");
        ClientDao dao = applCon.getBean("clientDao",ClientDao.class);
        
        /*
        Client client = new Client("KEYUR",new Date());
        int record = dao.store(client);
        System.out.println(record + " inserted using dao.\n");
        
        Client updClient = new Client(4,"John",new Date());
        int updRecord = dao.update(updClient);
        System.out.println(updRecord + " updated using dao.\n");
        
        int clientId = 3;
        int deleteRecord = dao.destroy(clientId);
        System.out.println(deleteRecord + " delete client ["+ clientId +"] using dao.");
    	*/
        
        int clientId = 5;
        System.out.println(dao.getClientById(clientId));
        
        List<Client> getAllClients = dao.getAll();
        getAllClients.forEach((e)->System.out.println(e));
    }
}

/* OUTPUT 
 
  	App :: main()
	START :: ClientDaoImpl :: getClientById()
	END :: ClientDaoImpl :: getClientById()
	Client [clientId=5, clientName=KEYUR, createdAt=2022-02-19, updatedAt=null]
	START :: ClientDaoImpl :: getAll()
	END :: ClientDaoImpl :: getAll()
	Client [clientId=1, clientName=John, createdAt=2022-02-19, updatedAt=2022-02-19]
	Client [clientId=4, clientName=John, createdAt=2022-02-19, updatedAt=2022-02-19]
	Client [clientId=5, clientName=KEYUR, createdAt=2022-02-19, updatedAt=null]
	Client [clientId=6, clientName=KEYUR, createdAt=2022-02-19, updatedAt=null]
	Client [clientId=7, clientName=JAY, createdAt=2022-02-19, updatedAt=null]
	Client [clientId=8, clientName=JAY, createdAt=2022-02-19, updatedAt=null]
	Client [clientId=9, clientName=JAY, createdAt=2022-02-19, updatedAt=null]

 */
