package com.peter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class JPAApplication {
    public static void main(String[] args) {
        SpringApplication.run(JPAApplication.class);
    }
}
