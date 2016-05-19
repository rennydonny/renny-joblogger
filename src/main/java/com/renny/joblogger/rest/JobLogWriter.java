package com.renny.joblogger.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.renny.joblogger.component.LogOutputComponent;
import com.renny.joblogger.component.OutputLoggerFactory;
import com.renny.joblogger.domain.LoggerEntity;
import com.renny.joblogger.repository.LoggerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@RestController("/writelog")
public class JobLogWriter {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private OutputLoggerFactory outputLoggerFactory;

    @Autowired
    private LoggerRepository loggerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> request = mapper.readValue(json, Map.class);
            String output = request.get("output");
            String message = request.get("message");
            String level = request.get("level");

            LogOutputComponent logOutputComponent = outputLoggerFactory.getLogOutputComponent(output);
            if(logOutputComponent !=null){
                logOutputComponent.writeLog(message,level);
            }

            logger.info("end");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<LoggerEntity> list(){
        return this.loggerRepository.findAll();
    }
}
