package com.sumit.MyDataSource;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@Component
public class CustomDataSource {

	
	@Value("${db.driver}")
	private String dbDriver;
	
	@Value("${db.host}")
	private String dbHost;
	
	@Value("${db.port}")
	private String dbPort;
	
	@Value("${db.username}")
	private String dbUsername;
	
	@Value("${db.password}")
	private String dbPassword;
	
	@Value("${db.name}")
	private String dbName;
	
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(dbDriver);
	    dataSource.setUrl("jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"");
	    dataSource.setUsername(dbUsername);
	    dataSource.setPassword(dbPassword);
	 
	    return dataSource;
	}
	
}
