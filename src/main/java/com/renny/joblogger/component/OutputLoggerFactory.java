package com.renny.joblogger.component;

import com.renny.joblogger.enums.LogOutputTypes;
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
    private Map<String, LogOutputComponent> map = new HashMap<>();

    @Autowired
    public OutputLoggerFactory(@Qualifier("logToConsoleComponent") LogOutputComponent logToConsoleComponent,
                               @Qualifier("logToFileComponent") LogOutputComponent logToFile,
                               @Qualifier("logToDatabaseComponent") LogOutputComponent logToDatabase) {
        map.put(LogOutputTypes.CONSOLE.getOutput(),logToConsoleComponent);
        map.put(LogOutputTypes.FILE.getOutput(),logToFile);
        map.put(LogOutputTypes.DATABASE.getOutput(),logToDatabase);
    }

    public LogOutputComponent getLogOutputComponent(String type){
        return map.get(type);
    }
}
