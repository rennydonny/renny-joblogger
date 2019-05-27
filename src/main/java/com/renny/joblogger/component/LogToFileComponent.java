package com.renny.joblogger.component;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.dto.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

@Component("logToFileComponent")
@Log
@RequiredArgsConstructor
public class LogToFileComponent implements LogOutputComponent {
    private final LoggerProperties loggerProperties;

    @Value(value = "${logging.file}")
    private String loggingFile;

    @Override
    public void push(LogMessageDTO logMessage) {
        Predicate<Level> isLogLevelEnabled = (Level logLevel) -> logLevel.equals(logMessage.getLevel().getLevel());
        Handler handlerType = getHandlerType();
        if(Objects.nonNull(handlerType)){
            log.addHandler(handlerType);
            this.loggerProperties.getLevels().stream().map(LogLevel::getLevel).filter(isLogLevelEnabled)
                    .forEach(level -> log.log(level,logMessage.getMessage()));
            handlerType.close();
        }
    }

    private Handler getHandlerType() {
        try {
            Handler handler = new FileHandler(this.loggingFile,true);
            handler.setFormatter(new SimpleFormatter());
            return handler;
        } catch (IOException e) {
            log.log(Level.SEVERE,e.getMessage(),e);
        }
        return null;
    }
}
