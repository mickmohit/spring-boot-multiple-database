package com.example.demo.model.db1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableAutoConfiguration
@Configuration
//@ComponentScan({"com.example.demo.repo.db2", "com.example.demo.model.db2"})

@EnableJpaRepositories(
        basePackages = {"com.example.demo.*"},
        entityManagerFactoryRef = "entityManagerFactory", 
        transactionManagerRef = "transactionManager")
@EnableTransactionManagement
/*@EntityScan(basePackages = "com.example.demo")  */
public class Database2Config {

    @Bean(name = "transactionManager")
    //@Primary
    public PlatformTransactionManager transactionManager2() {
        return new JpaTransactionManager(entityManagerFactory2().getObject());
    }

    @Bean(name = "entityManagerFactory")
 //@Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource2());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(hibernateProperties());

        factoryBean.setPackagesToScan("com.example.demo.*");
        factoryBean.setPersistenceUnitName("db2");

        return factoryBean;
    }

    //@Primary
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "datasource2")
    public DataSource dataSource2() {
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
