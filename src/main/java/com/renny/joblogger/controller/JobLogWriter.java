package com.renny.joblogger.controller;

import com.renny.joblogger.api.JobLoggerService;
import com.renny.joblogger.dto.LogMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "log",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
