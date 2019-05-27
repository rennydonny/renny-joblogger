package com.renny.joblogger.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LoggerEntityTest {

    @Test
    public void loggerEntityShouldBeCreated() {
        LoggerEntity entity = new LoggerEntity(1L,"HELLO WORLD!","com.renny.joblogger.component.LogToDatabaseComponent");
        Assertions.assertThat(entity.getMessage()).isEqualToIgnoringCase("HELLO WORLD!");
        Assertions.assertThat(entity.getId()).isEqualTo(1L);
        Assertions.assertThat(entity.getName()).isEqualToIgnoringCase("com.renny.joblogger.component.LogToDatabaseComponent");
    }

}