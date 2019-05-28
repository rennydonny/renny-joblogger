package com.renny.joblogger;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableConfigurationProperties(value = {LoggerProperties.class})
public class JobLoggerApp {

}
