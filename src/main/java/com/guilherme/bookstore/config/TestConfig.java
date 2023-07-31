package com.guilherme.bookstore.config;


import com.guilherme.bookstore.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBservice dBservice;

    @Bean
    public void instanciaBasedeDados() {
        this.dBservice.instanciaBaseDeDados();
    }

}
