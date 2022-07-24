//package com.javatechie.spring.batch.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//@Primary
//public class SourceDataDB {
//
//    @Bean
//    @Primary
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost/ssmysqldb");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("test");
//        return dataSourceBuilder.build();
//    }
//
//
//}
//
//
