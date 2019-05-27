package com.renny.joblogger.component;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.domain.LoggerEntity;
import com.renny.joblogger.dto.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import com.renny.joblogger.model.LogOutputType;
import com.renny.joblogger.repository.LoggerRepository;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

@Log
@RunWith(SpringRunner.class)
@DataJpaTest
public class LogToDatabaseComponentTest {
    @Autowired
    private LoggerRepository repository;
    @Test
    public void logMessageSavedSuccess(){
        LoggerProperties loggerProperties = new LoggerProperties();
        loggerProperties.setLevels(Collections.singletonList(LogLevel.WARN));
        loggerProperties.setOutputs(Collections.singletonList(LogOutputType.DATABASE));
        LogToDatabaseComponent component = new LogToDatabaseComponent(loggerProperties,this.repository);
        component.push(new LogMessageDTO("TEST MESSAGE", LogLevel.WARN));
        Optional<LoggerEntity> byId = this.repository.findById(1L);
        Assertions.assertThat(byId.isPresent()).isTrue();
    }

}