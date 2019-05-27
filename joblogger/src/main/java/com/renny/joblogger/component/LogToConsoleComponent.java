package com.renny.joblogger.component;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.dto.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.logging.*;

@Component("logToConsoleComponent")
@Log
@RequiredArgsConstructor
public class LogToConsoleComponent  implements LogOutputComponent {
    private final LoggerProperties loggerProperties;

    @Override
    public void push(LogMessageDTO logMessage) {
        Predicate<Level> isLogLevelEnabled = (Level logLevel) -> logLevel.equals(logMessage.getLevel().getLevel());
        log.addHandler(getHandlerType());
        this.loggerProperties.getLevels().stream().map(LogLevel::getLevel).filter(isLogLevelEnabled)
                .forEach(level -> log.log(level,logMessage.getMessage()));
    }

    private Handler getHandlerType() {
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        return handler;
    }
}
