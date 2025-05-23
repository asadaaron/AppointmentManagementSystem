/*
package com.example.appointmentmanagementsystem.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    private final DatabaseProperties dbProps;

    public DataSourceConfig(DatabaseProperties dbProps) {
        this.dbProps = dbProps;
    }
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dbProps.getUrl());
        dataSource.setUsername(dbProps.getUsername());
        dataSource.setPassword(dbProps.getPassword());
        dataSource.setDriverClassName(dbProps.getDriverClassName());
        return dataSource;
    }
}

*/
