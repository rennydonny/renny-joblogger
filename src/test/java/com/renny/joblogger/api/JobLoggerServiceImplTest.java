package com.renny.joblogger.api;

import com.renny.joblogger.LoggerProperties;
import com.renny.joblogger.component.LogToConsoleComponent;
import com.renny.joblogger.component.LogToDatabaseComponent;
import com.renny.joblogger.component.LogToFileComponent;
import com.renny.joblogger.component.OutputLoggerFactory;
import com.renny.joblogger.dto.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import com.renny.joblogger.model.LogOutputType;
import com.renny.joblogger.repository.LoggerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
public class JobLoggerServiceImplTest {
    @Mock
    private LoggerProperties properties;

    @Mock
    private LoggerRepository repository;

    @Test
    public void writeLogShouldBeOk(){
        OutputLoggerFactory factory = new OutputLoggerFactory(new LogToConsoleComponent(properties),
                new LogToDatabaseComponent(properties,repository),
                new LogToFileComponent(properties));
        JobLoggerService service = new JobLoggerServiceImpl(properties,factory);
        Mockito.when(properties.getLevels()).thenReturn(Collections.singletonList(LogLevel.WARN));
        Mockito.when(properties.getOutputs()).thenReturn(Collections.singletonList(LogOutputType.FILE));
        boolean result = service.write(new LogMessageDTO("TEST MESSAGE", LogLevel.WARN));
        Assertions.assertThat(result).isTrue();
    }

}