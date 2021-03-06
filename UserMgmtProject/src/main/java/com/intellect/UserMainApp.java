package com.intellect;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EntityScan(basePackages="com.intellect.model")
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan(basePackages="com.*")
@EnableJpaAuditing
public class UserMainApp{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserMainApp.class, args);
    }
    

}