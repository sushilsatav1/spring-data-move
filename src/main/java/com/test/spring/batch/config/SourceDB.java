package com.test.spring.batch.config;

import com.test.spring.batch.entity.LetterHistDb2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

import static java.lang.System.getProperty;

@Configuration
    @EnableJpaRepositories(
            basePackages = {"com.test.spring.batch.repository.db1"},
            entityManagerFactoryRef = "srcEntityManager",
            transactionManagerRef = "srcTransactionManager")
    public class SourceDB {

        @Primary

        @Bean(name="primaryDataSource")
        @ConfigurationProperties(prefix="spring.datasource")
        public DataSource srcDataSource() {
//            return DataSourceBuilder.create().build();
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost/ssmysqldb");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("test");
        return dataSourceBuilder.build();
        }
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean srcEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(srcDataSource());

        em.setPackagesToScan("com.test.spring.batch.entity");
        em.setPersistenceUnitName("LetterHistDb2");

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }
    @Primary
    @Bean
    public PlatformTransactionManager srcTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                srcEntityManager().getObject());
        return transactionManager;
    }    }

