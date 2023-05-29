package com.practice.invoiceservice.configuration;

import com.practice.invoiceservice.properties.DataSourceProperties;
import com.practice.invoiceservice.properties.LiquibaseProperties;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LiquibaseConfiguration {
    @Autowired
    private LiquibaseProperties liquibaseProperties;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public SpringLiquibase liquibase() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverName());
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(liquibaseProperties.getUser());
        dataSource.setPassword(liquibaseProperties.getPassword());
        dataSource.setSchema(dataSourceProperties.getSchema());

        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:/changelog/db.changelog.yaml");
        liquibase.setDataSource(dataSource);
        liquibase.setLiquibaseSchema(liquibaseProperties.getSchema());

        Map<String, String> parameters = new HashMap<>();
        parameters.put("usrName", dataSourceProperties.getUserName());
        parameters.put("userPassword", dataSourceProperties.getPassword());
        parameters.put("schema", dataSourceProperties.getSchema());
        parameters.put("roleName", liquibaseProperties.getRoleName());

        liquibase.setChangeLogParameters(parameters);

        return liquibase;
    }
}
