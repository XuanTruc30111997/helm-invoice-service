package com.practice.invoiceservice.configuration;

import com.practice.invoiceservice.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(dataSourceProperties.getDriverName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUserName());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setSchema(dataSourceProperties.getSchema());

        return dataSource;
    }
}
