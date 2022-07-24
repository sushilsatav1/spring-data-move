//package com.javatechie.spring.batch.config;
//
//
//import com.javatechie.spring.batch.entity.LetterHistDb2;
//import com.javatechie.spring.batch.entity.LetterHistDest;
//import com.javatechie.spring.batch.repository.DestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.util.Objects;
//
//@Configuration
//    @EnableTransactionManagement
//    @EnableJpaRepositories(
//            basePackageClasses = LetterHistDest.class,
//            entityManagerFactoryRef = "destEntityManagerFactory",
//            transactionManagerRef = "destTransactionManager"
//    )
//    public class DestEntityConfig {
//    @Autowired DestDataDB destDataDB;
//        @Bean
//        public LocalContainerEntityManagerFactoryBean destEntityManagerFactory(
//                 EntityManagerFactoryBuilder builder) {
//            return builder
//                    .dataSource(destDataDB.getDataSourceDest())
//                    .packages(LetterHistDest.class)
//                    .build();
//        }
//
//        @Bean
//        public PlatformTransactionManager destTransactionManager(
//                @Qualifier("destEntityManagerFactory") LocalContainerEntityManagerFactoryBean destEntityManagerFactory) {
//            return new JpaTransactionManager(Objects.requireNonNull(destEntityManagerFactory.getObject()));
//        }
//
//    }
//
//
//
//
