package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.db1.MainController;


/*@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories*/

//@EntityScan(basePackageClasses = MainController.class)  
//@Configuration
//@ComponentScan(basePackageClasses = MainController.class)

/*@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class})
*///@ComponentScan({"com.example.demo.repo.*", "com.example.demo.model.*" })
//@ComponentScan({"com.example.demo.repo.*"})
/*@SpringBootApplication(
		exclude = {DataSourceAutoConfiguration.class,
				HibernateJpaAutoConfiguration.class,
				DataSourceTransactionManagerAutoConfiguration.class
		}
		)*/

//@EnableTransactionManagement
/*@ComponentScan(basePackages = {"com.example.demo.*"}) 
@EntityScan("com.example.demo.*")   

@EnableJpaRepositories("com.example.demo.*")
*/

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories

public class SpringBootMultipleDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDatabaseApplication.class, args);
	}
}
