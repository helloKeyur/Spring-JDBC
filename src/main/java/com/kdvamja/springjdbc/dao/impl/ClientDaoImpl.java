package com.kdvamja.springjdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kdvamja.springjdbc.dao.ClientDao;
import com.kdvamja.springjdbc.entity.Client;
import com.kdvamja.springjdbc.mapper.ClientMapper;

public class ClientDaoImpl implements ClientDao{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int store(Client client) {
		System.out.println("START :: ClientDaoImpl :: store()");
		String insertQuery = "INSERT INTO clients(client_name, created_at) values(?,?)";
		int result = jdbcTemplate.update(insertQuery, client.getClientName(), client.getCreatedAt());
		System.out.println("END :: ClientDaoImpl :: store()");
		return result;
	}
	
	public int update(Client client) {
		System.out.println("START :: ClientDaoImpl :: update()");
		String updateQuery = "UPDATE clients SET client_name=?, updated_at=? WHERE client_id=?";
		int result = jdbcTemplate.update(updateQuery, client.getClientName(), client.getUpdatedAt(), client.getClientId());
		System.out.println("END :: ClientDaoImpl :: update()");
		return result;
	}
	
	public int destroy(int clientId) {
		System.out.println("START :: ClientDaoImpl :: destroy()");
		String deleteQuery = "DELETE FROM clients WHERE client_id=?";
		int result = jdbcTemplate.update(deleteQuery, clientId);
		System.out.println("END :: ClientDaoImpl :: destroy()");
		return result;
	}
	
	public Client getClientById(int clientId) {
		System.out.println("START :: ClientDaoImpl :: getClientById()");
		String getClientQuery = "SELECT * FROM clients WHERE client_id = ?";
		ClientMapper rm = new ClientMapper();
		Client client = jdbcTemplate.queryForObject(getClientQuery, rm, clientId);
		System.out.println("END :: ClientDaoImpl :: getClientById()");
		return client;
	}
	
	public List<Client> getAll() {
		System.out.println("START :: ClientDaoImpl :: getAll()");
		String getClientsQuery = "SELECT * FROM clients";
		ClientMapper rm = new ClientMapper();
		List<Client> clients = jdbcTemplate.query(getClientsQuery, rm);
		System.out.println("END :: ClientDaoImpl :: getAll()");
		return clients;
	}
}
