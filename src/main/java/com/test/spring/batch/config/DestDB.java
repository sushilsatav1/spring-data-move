package com.test.spring.batch.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
    @EnableJpaRepositories(
            basePackages = {"com.test.spring.batch.repository.db2"},
            entityManagerFactoryRef = "destEntityManager",
            transactionManagerRef = "destTransactionManager")
    public class DestDB {


        @Bean
//        @ConfigurationProperties(prefix="spring.datasource")
        public DataSource destDataSource() {
//            return DataSourceBuilder.create().build();
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost/ssmysqldb2");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("test");
        return dataSourceBuilder.build();
        }
    @Bean

    public LocalContainerEntityManagerFactoryBean destEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(destDataSource());

        em.setPackagesToScan("com.test.spring.batch.entity");
        em.setPersistenceUnitName("LetterHistDest");

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
//        HashMap<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto",
//                getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect",
//                getProperty("hibernate.dialect"));
//        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager destTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                destEntityManager().getObject());
        return transactionManager;
    }    }

