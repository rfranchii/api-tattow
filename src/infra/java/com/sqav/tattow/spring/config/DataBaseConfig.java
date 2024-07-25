package com.sqav.tattow.spring.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sqav.tattow.support.PropertyManager;

@Profile("default-pool")
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:hibernate-config.properties" })
public class DataBaseConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseConfig.class);

	@Autowired(required = false)
	private Environment environment;

	@Autowired
	private PropertyManager propertyManager;
	
	private static final String[] packagesToScan = {
			"br.net.connectcare.doutorvirtual.model", 
			"br.net.connectcare.doutorvirtual.profissionalsaudesaas.model", 
			"br.net.connectcare.doutorvirtual.v2.entities", 
			"br.net.connectcare.doutorvirtual.integracaoparceiroexterno.model", 
			"br.com.conexasaude.cabinemedica.model", 
			"br.net.connectcare.doutorvirtual.integracaoempresaparceira.model",
			"br.com.conexasaude.integrationservicesecurity.model",
			"br.net.connectcare.doutorvirtual.integracaoempresaexterna.model"
	};

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("writer");
		emf.setDataSource(dataSource);
		emf.setPackagesToScan(packagesToScan);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(hibernateProperties());

		return emf;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryReader(DataSource dataSourceReader) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("reader");
		emf.setDataSource(dataSourceReader);
		emf.setPackagesToScan(packagesToScan);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(hibernateProperties());

		return emf;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		if (environment != null) {
			Map<String, Object> map = new HashMap<>();
			for (Iterator<org.springframework.core.env.PropertySource<?>> it = ((AbstractEnvironment) environment)
					.getPropertySources().iterator(); it.hasNext();) {
				org.springframework.core.env.PropertySource<?> propertySource = it.next();
				if (propertySource instanceof MapPropertySource) {
					map.putAll(((MapPropertySource) propertySource).getSource());
				}
			}

			for (Entry<String, Object> entrySet : map.entrySet()) {
				properties.put(entrySet.getKey(), entrySet.getValue());
			}
		}
		return properties;
	}

	@Bean
	public DataSource dataSource() {
		try {
			Properties connectionProperties = new Properties();
			connectionProperties.put("characterEncoding", "latin1");
			connectionProperties.put("characterSetResults", "latin1");
			connectionProperties.put("connectionCollation ", "latin1_swedish_ci");

			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(propertyManager.getEnvironmentProperty("datasource.db.driver"));
			dataSource.setUsername(propertyManager.getEnvironmentProperty("datasource.db.user"));
			dataSource.setPassword(propertyManager.getEnvironmentProperty("datasource.db.passwd"));
			dataSource.setUrl(propertyManager.getEnvironmentProperty("datasource.db.url"));
			dataSource.setConnectionProperties(connectionProperties);
			LOGGER.info("Carregando bean datasource {}", dataSource);
			return dataSource;
		} catch (Exception e) {
			LOGGER.error("Erro ao obter dados do JNDI de conexão.", e);
			return null;
		}
	}

	@Bean
	public DataSource dataSourceReader() {
		try {
			Properties connectionProperties = new Properties();
			connectionProperties.put("characterEncoding", "latin1");
			connectionProperties.put("characterSetResults", "latin1");
			connectionProperties.put("connectionCollation ", "latin1_swedish_ci");

			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(propertyManager.getEnvironmentProperty("datasource.db.driver"));
			dataSource.setUsername(propertyManager.getEnvironmentProperty("datasource.db.user"));
			dataSource.setPassword(propertyManager.getEnvironmentProperty("datasource.db.passwd"));
			dataSource.setUrl(propertyManager.getEnvironmentProperty("datasource.db.reader.url"));
			dataSource.setConnectionProperties(connectionProperties);
			LOGGER.info("Carregando bean datasource {}", dataSource);
			return dataSource;
		} catch (Exception e) {
			LOGGER.error("Erro ao obter dados do JNDI de conexão.", e);
			return null;
		}
	}

//	@Bean
//	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory);
//		return transactionManager;
//	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplateReader(DataSource dataSourceReader) {
		return new NamedParameterJdbcTemplate(dataSourceReader);
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
