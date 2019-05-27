package com.renny.logclient;

import com.renny.joblogger.JobLoggerApp;
import com.renny.joblogger.LoggerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {JobLoggerApp.class})
@EnableConfigurationProperties(value = {LoggerProperties.class})
public class LogClientApp {

    public static void main(String[] args) {
        SpringApplication.run(LogClientApp.class, args);
    }
}
