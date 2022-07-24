//package com.javatechie.spring.batch.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DestDataDB {
//
//    @Bean
//    @Qualifier("sourceDataDB")
////    @ConfigurationProperties("spring.datasource.dest.hikari")
//    public DataSource getDataSourceDest() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost/ssmysqldb2");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("test");
//        return dataSourceBuilder.build();
//    }
//
//
//}
//
//
