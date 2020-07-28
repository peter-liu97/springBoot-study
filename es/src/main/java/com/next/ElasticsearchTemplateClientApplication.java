package com.next;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ElasticsearchTemplateClientApplication{
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchTemplateClientApplication.class,args);
    }
}
