package com.renny.joblogger.component;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.domain.LoggerEntity;
import com.renny.joblogger.dto.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import com.renny.joblogger.repository.LoggerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component("logToDatabaseComponent")
@Log
@RequiredArgsConstructor
public class LogToDatabaseComponent implements LogOutputComponent {
    private final LoggerProperties loggerProperties;
    private final LoggerRepository loggerRepository;
    @Override
    public void push(LogMessageDTO logMessage) {
        Predicate<LogLevel> isLogLevelEnabled = (LogLevel logLevel) -> logLevel.getLevel().equals(logMessage.getLevel().getLevel());
        this.loggerProperties.getLevels().stream().filter(isLogLevelEnabled)
                .forEach(level -> publish(level,logMessage.getMessage()));
    }

    private void publish(LogLevel logLevel, String message) {
        String messageToSave = String.format("%s,%s",logLevel.getCategory(),message);
        String name = log.getName();
        LoggerEntity loggerEntity = new LoggerEntity();
        loggerEntity.setMessage(messageToSave);
        loggerEntity.setName(name);
        this.loggerRepository.save(loggerEntity);
    }


}
