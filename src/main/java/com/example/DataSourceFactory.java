package com.example;

import jakarta.inject.Singleton;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Singleton
public class DataSourceFactory {

	@Singleton
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:postgresql://localhost:5433/demo_db");
		config.setUsername("postgres");
		config.setPassword("root");
		config.setDriverClassName("org.postgresql.Driver");
		return new HikariDataSource(config);
	}
}
