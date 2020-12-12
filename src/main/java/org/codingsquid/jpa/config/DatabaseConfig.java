package org.codingsquid.jpa.config;

import com.zaxxer.hikari.HikariDataSource;
import org.codingsquid.jpa.config.properties.DatabaseProperties;
import org.codingsquid.jpa.config.properties.PlayJpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@Configuration
@EnableConfigurationProperties(value = { DatabaseProperties.class, PlayJpaProperties.class })
public class DatabaseConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, PlayJpaProperties jpaProperties) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("org.codingsquid.jpa.entity");
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setGenerateDdl(jpaProperties.isGenerateDdl());
        hibernateJpaVendorAdapter.setShowSql(jpaProperties.isShowSql());
        emf.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        emf.setJpaProperties(jpaProperties.toProperties());
        emf.afterPropertiesSet();
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public DataSource dataSource(DatabaseProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setMaximumPoolSize(properties.getMaxConnection());
        dataSource.setMinimumIdle(properties.getMinConnection());
        return dataSource;
    }
}
