package com.example.demo.model.db1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@ComponentScan({"com.example.demo.repo.db1", "com.example.demo.model.db1"})
@EnableAutoConfiguration
//@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        basePackages = {"com.example.demo.*"},
        entityManagerFactoryRef = "entityManagerFactory", 
        transactionManagerRef = "transactionManager")
//@EntityScan("com.example.demo.model.db1")  
@EnableTransactionManagement
public class Database1Config {

    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager1() {
        return new JpaTransactionManager(entityManagerFactory1().getObject());
    }

    @Bean(name = "entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource1());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(hibernateProperties());

        //factoryBean.setPackagesToScan("com.example.demo.repo.db1");
        factoryBean.setPackagesToScan("com.example.demo.*");
        factoryBean.setPersistenceUnitName("db1");

        return factoryBean;
    }

    @Primary
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "datasource1")
    public DataSource dataSource1() {
        return DataSourceBuilder
                .create()
                .build();
    }

    private Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        return hibernateProperties;
    }
}
