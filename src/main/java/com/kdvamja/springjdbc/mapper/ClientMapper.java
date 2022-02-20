package com.kdvamja.springjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kdvamja.springjdbc.entity.Client;

public class ClientMapper implements RowMapper<Client>{

	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setClientId(rs.getInt(1));
		client.setClientName(rs.getString(2));
		client.setCreatedAt(rs.getDate(3));
		client.setUpdatedAt(rs.getDate(4));
		return client;
	}

}
