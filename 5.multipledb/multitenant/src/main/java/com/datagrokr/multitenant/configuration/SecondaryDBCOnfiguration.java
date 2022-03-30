package com.datagrokr.multitenant.configuration;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.datagrokr.multitenant.repository.secondary", 
    entityManagerFactoryRef = "secondaryEntityManagerFactory", 
    transactionManagerRef = "secondaryTransactionManager")
public class SecondaryDBCOnfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSourceProperties secondaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.secondary.configuration")
    public DataSource secondaryDataSource() {
        return secondaryDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder,
            @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        return builder
                .dataSource(secondaryDataSource())
                .packages("com.datagrokr.multitenant.entity.secondary")
                .build();
    }

    @Bean
    public PlatformTransactionManager secondaryTransactionManager(
            final @Qualifier("secondaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory) {
        return new JpaTransactionManager(secondaryEntityManagerFactory.getObject());
    }
}
