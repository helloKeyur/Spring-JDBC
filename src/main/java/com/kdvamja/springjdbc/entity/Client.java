package com.kdvamja.springjdbc.entity;

import java.util.Date;

/*
 
CREATE TABLE `clients` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `client_name` varchar(45) NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date DEFAULT NULL,
  PRIMARY KEY (`client_id`)
)
 
 * */
public class Client {
	private int clientId;
	private String clientName;
	private Date createdAt;
	private Date updatedAt;
	
	public Client() {
		super();
	}
	
	public Client(String clientName, Date createdAt) {
		super();
		this.clientName = clientName;
		this.createdAt = createdAt;
	}
	
	public Client(int clientId, String clientName, Date updatedAt) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.updatedAt = updatedAt;
	}

	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
