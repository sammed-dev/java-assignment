package com.datagrokr.multitenant.configuration;

import javax.sql.DataSource;

import com.datagrokr.multitenant.entity.primary.PrimaryBook;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.datagrokr.multitenant.repository.primary",
    entityManagerFactoryRef = "primaryEntityManagerFactory",
    transactionManagerRef = "primaryTransactionManager"
)
public class PrimaryDBConfiguration {
    
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSourceProperties primaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.primary.configuration")
    public DataSource primaryDataSource(){
        return primaryDataSourceProperties().initializeDataSourceBuilder()
            .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDataSource") DataSource primaryDataSource) {
        return builder
                .dataSource(primaryDataSource())
                .packages("com.datagrokr.multitenant.entity.primary")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager primaryTransactionManager(
            final @Qualifier("primaryEntityManagerFactory") LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory) {
        return new JpaTransactionManager(primaryEntityManagerFactory.getObject());
    }

}
