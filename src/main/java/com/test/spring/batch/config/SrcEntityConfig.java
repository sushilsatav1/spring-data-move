//package com.javatechie.spring.batch.config;
//
//
//import com.javatechie.spring.batch.entity.LetterHistDb2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
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
//            basePackageClasses = LetterHistDb2.class,
//            entityManagerFactoryRef = "srcEntityManagerFactory",
//            transactionManagerRef = "srcTransactionManager"
//    )
//    public class SrcEntityConfig {
//    @Autowired SourceDataDB sourceDataDB;
//        @Bean
//        @Primary
//        public LocalContainerEntityManagerFactoryBean srcEntityManagerFactory(
//                 EntityManagerFactoryBuilder builder) {
//            return builder
//                    .dataSource(sourceDataDB.getDataSource())
//                    .packages(LetterHistDb2.class)
//                    .build();
//        }
//
//        @Bean
//        public PlatformTransactionManager srcTransactionManager(
//                @Qualifier("srcEntityManagerFactory") LocalContainerEntityManagerFactoryBean srcEntityManagerFactory) {
//            return new JpaTransactionManager(Objects.requireNonNull(srcEntityManagerFactory.getObject()));
//        }
//
//    }
//
//
//
//
