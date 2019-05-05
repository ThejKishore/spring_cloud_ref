package com.kish.boot.learning.cloudconfigserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigServer
@Slf4j
public class CloudConfigServerApplication {

    @Value("${greet.msg}")
    private String value;

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext appContext) {
        return args -> {
            log.info(" ====> greet {}",value);
        };
    }
}
