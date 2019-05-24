package com.renny.joblogger.controller;

import com.renny.joblogger.api.JobLoggerService;
import com.renny.joblogger.dtos.LogMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "log")
@Log
@RequiredArgsConstructor
public class JobLogWriter {
    private final JobLoggerService loggerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody LogMessageDTO message){
        log.info(String.format("Log message received %s",message.toString()));
        this.loggerService.write(message);
    }
}
