package com.renny.joblogger.component;

import com.renny.joblogger.model.LogOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@Component
public class OutputLoggerFactory {
    private Map<LogOutputType, LogOutputComponent> map = new HashMap<>();

    @Autowired
    public OutputLoggerFactory(@Qualifier("logToConsoleComponent") LogOutputComponent logToConsoleComponent,
                               @Qualifier("logToFileComponent") LogOutputComponent logToFile,
                               @Qualifier("logToDatabaseComponent") LogOutputComponent logToDatabase) {
        map.put(LogOutputType.CONSOLE,logToConsoleComponent);
        map.put(LogOutputType.FILE,logToFile);
        map.put(LogOutputType.DATABASE,logToDatabase);
    }

    public LogOutputComponent getLogOutputComponent(LogOutputType outputType){
        return map.get(outputType);
    }
}
