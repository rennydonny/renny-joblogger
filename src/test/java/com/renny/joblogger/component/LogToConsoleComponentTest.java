package com.renny.joblogger.component;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.dto.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import com.renny.joblogger.model.LogOutputType;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.Collections;

@Log
public class LogToConsoleComponentTest {
    @Test
    public void shouldHaveAHandlerOkInstance(){
        LoggerProperties loggerProperties = new LoggerProperties();
        loggerProperties.setLevels(Collections.singletonList(LogLevel.WARN));
        loggerProperties.setOutputs(Collections.singletonList(LogOutputType.CONSOLE));
        LogToConsoleComponent c = new LogToConsoleComponent(loggerProperties);
        c.push(new LogMessageDTO("TEST MESSAGE", LogLevel.WARN));
        log.info("FINISHED");
    }


}