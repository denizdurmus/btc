package net.kadirderer.btc.config;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages = {"net.kadirderer.btc.db.repository"})
@ComponentScan(basePackages = {"net.kadirderer.btc.query", "net.kadirderer.btc.db", "net.kadirderer.btc.exchangerate" })
@PropertySource(value = "classpath:application.properties")
public class ApplicationConfig {	
	
	@Value("${btcchina.orderbook.url}")
	private String btcChinaOrderBookUrl;
	
	@Value("${btcturk.orderbook.url}")
	private String btcTurkOrderBookUrl;
	
	@Value("${exchangerate.query.url}")
	private String exchangeRateQueryUrl;
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	@Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPackagesToScan("net.kadirderer.btc.db.model");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

        Properties jpaProterties = new Properties();
        
        try {
			jpaProterties.load(getClass().getClassLoader().getResourceAsStream("hibernate.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        entityManagerFactoryBean.setJpaProperties(jpaProterties);

        return entityManagerFactoryBean;
    }

	public String getBtcChinaOrderBookUrl() {
		return btcChinaOrderBookUrl;
	}

	public String getBtcTurkOrderBookUrl() {
		return btcTurkOrderBookUrl;
	}


	public String getExchangeRateQueryUrl() {
		return exchangeRateQueryUrl;
	}
    
	

}
