package com.senla.hotel.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class UpConfig {

//    @Value("${spring.jpa.properties.hibernate.dialect}")
//    private String dialect;
//
//    @Value("${spring.jpa.properties.hibernate.ejb.naming_strategy}")
//    private String namingStrategy;
//
//    @Value("${spring.jpa.properties.hibernate.show_sql}")
//    private String showSql;
//
//    @Value("${spring.jpa.properties.hibernate.format_sql}")
//    private String formatSql;
//
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String validation;

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(dataSource);
//        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactory.setPackagesToScan("com.senla.hotel.model");
//        entityManagerFactory.setJpaProperties(getJpaProperties());
//
//        return entityManagerFactory;
//    }
//
//    private Properties getJpaProperties() {
//        Properties jpaProperties = new Properties();
//
//        // Configures the used database dialect. This allows Hibernate to create SQL
//        // that is optimized for the used database.
//        jpaProperties.put("hibernate.dialect", dialect);
//
//        // Configures the naming strategy that is used when Hibernate creates
//        // new database objects and schema elements
//        jpaProperties.put("hibernate.ejb.naming_strategy", namingStrategy);
//
//        // If the value of this property is true, Hibernate writes all SQL
//        // statements to the console.
//        jpaProperties.put("hibernate.show_sql", showSql);
//
//        // If the value of this property is true, Hibernate will format the SQL
//        // that is written to the console.
//        jpaProperties.put("hibernate.format_sql", formatSql);
//
////        jpaProperties.put("hibernate.hbm2ddl.auto", validation);
//
//        return jpaProperties;
//    }
}
