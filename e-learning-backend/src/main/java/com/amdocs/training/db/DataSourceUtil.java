package com.amdocs.training.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceUtil {
	
	public static DataSource dataSource() {

		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/elearning");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;

	}

}
