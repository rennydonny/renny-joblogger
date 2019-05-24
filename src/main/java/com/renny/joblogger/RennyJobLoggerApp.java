package com.renny.joblogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {LoggerProperties.class})
public class RennyJobLoggerApp {

    public static void main(String[] args) {
        SpringApplication.run(RennyJobLoggerApp.class, args);
    }

}
