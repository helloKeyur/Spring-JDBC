package com.kdvamja.autoconfiguration;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kdvamja.springjdbc.dao.ClientDao;
import com.kdvamja.springjdbc.entity.Client;

public class Application {
	
	private static ApplicationContext applCon;
	
	public static void main(String args[]) {
		System.out.println( "autoconfiguration.Application :: main()" );
        applCon = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ClientDao dao = applCon.getBean("clientDao",ClientDao.class);
        
        
        Client client = new Client("JAY",new Date());
        int record = dao.store(client);
        System.out.println(record + " inserted using dao.\n");
        
        Client updClient = new Client(4,"John",new Date());
        int updRecord = dao.update(updClient);
        System.out.println(updRecord + " updated using dao.\n");
        
        int clientId = 3;
        int deleteRecord = dao.destroy(clientId);
        System.out.println(deleteRecord + " delete client ["+ clientId +"] using dao.");
    	
        
        int getClientById = 5;
        System.out.println(dao.getClientById(getClientById));
        
        List<Client> getAllClients = dao.getAll();
        getAllClients.forEach((e)->System.out.println(e));
	}
}

/* OUTPUT

	autoconfiguration.Application :: main()
	START :: ClientDaoImpl :: store()
	END :: ClientDaoImpl :: store()
	1 inserted using dao.
	
	START :: ClientDaoImpl :: update()
	END :: ClientDaoImpl :: update()
	1 updated using dao.
	
	START :: ClientDaoImpl :: destroy()
	END :: ClientDaoImpl :: destroy()
	0 delete client [3] using dao.
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
