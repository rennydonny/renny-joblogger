package com.renny.joblogger.component;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.dtos.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.DirectoryStream;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.*;

/**
 * Created by renrodriguez on 5/3/2016.
 */
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
