package com.tiarebalbi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Contexto da camada de persistencia
 * 
 * @author Tiarê Balbi Bonamini
 */
@Configuration
@ComponentScan(basePackages={"com.tiarebalbi.query", "com.tiarebalbi.service"})
@EnableJpaRepositories("com.tiarebalbi.repository")
@EnableJpaAuditing
@EnableTransactionManagement
@PropertySource(value="classpath:application.properties")
public class DataContext {
	
	@Autowired
	private Environment env;
	
	/**
	 * Configuração do DataSource com o banco Apache Derby
	 * 
	 * @return {@link DataSource}
	 * http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/htmlsingle/#jdbc-embedded-database-using-Derby 
	 */
	@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.DERBY)
            .setName("votacao")
            .build();
    }
	
	/**
	 * @return {@link LocalContainerEntityManagerFactoryBean}
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.DERBY);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(this.env.getRequiredProperty("entity.package.scan"));
		factory.setDataSource(dataSource());

		return factory;
	}
	
	/**
	 * @return {@link PlatformTransactionManager}
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}
