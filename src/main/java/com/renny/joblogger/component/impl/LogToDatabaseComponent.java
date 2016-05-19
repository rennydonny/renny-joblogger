package com.renny.joblogger.component.impl;

import com.renny.joblogger.component.LogLevelFactory;
import com.renny.joblogger.component.LogOutputComponent;
import com.renny.joblogger.domain.LoggerEntity;
import com.renny.joblogger.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@Component("logToDatabaseComponent")
public class LogToDatabaseComponent implements LogOutputComponent {

    @Autowired
    private LoggerRepository loggerRepository;

    @Autowired
    private LogLevelFactory logLevelFactory;


    @Override
    public void writeLog(String message, String logLevel)throws Exception {
        LoggerEntity loggerEntity = new LoggerEntity();
        String text = String.format("%s,%s",message, logLevelFactory.getLogLevel(logLevel).getCategory());
        loggerEntity.setMessage(text);
        loggerRepository.save(loggerEntity);
    }
}
