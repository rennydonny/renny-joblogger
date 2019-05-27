package com.renny.joblogger.api;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.component.OutputLoggerFactory;
import com.renny.joblogger.dto.LogMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
@RequiredArgsConstructor
public class JobLoggerServiceImpl implements JobLoggerService{
    private final LoggerProperties loggerProperties;
    private final OutputLoggerFactory outputLoggerFactory;

    public boolean write(LogMessageDTO message){
        boolean isEmpty = this.loggerProperties.getLevels().isEmpty() || this.loggerProperties.getOutputs().isEmpty();
        if(isEmpty){throw new IllegalArgumentException("Log level and output must be set");}
        log.info(String.format("Writing just %s log levels on %s",this.loggerProperties.getLevels(),this.loggerProperties.getOutputs()));
        this.loggerProperties.getOutputs().stream().map(this.outputLoggerFactory::getLogOutputComponent)
                .forEach(logOutputComponent -> logOutputComponent.push(message));
        return true;
    }
}
