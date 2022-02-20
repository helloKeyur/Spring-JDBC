package com.kdvamja.springjdbc.dao;

import java.util.List;

import com.kdvamja.springjdbc.entity.Client;

public interface ClientDao {
	
	public int store(Client client);
	public int update(Client client);
	public int destroy(int clientId);
	public Client getClientById(int clientId);
	public List<Client> getAll();
}
