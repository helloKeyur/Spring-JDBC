package com.kdvamja.springjdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.kdvamja.springjdbc.dao.ClientDao;
import com.kdvamja.springjdbc.dao.impl.ClientDaoImpl;

@Configuration
public class ApplicationConfig {
	
	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(this.getDataSource());
		return template;
	}
	
	@Bean("clientDao")
	public ClientDao getClientDao() {
		ClientDaoImpl dao = new ClientDaoImpl();
		dao.setJdbcTemplate(this.getJdbcTemplate());
		return dao;
	}
}
