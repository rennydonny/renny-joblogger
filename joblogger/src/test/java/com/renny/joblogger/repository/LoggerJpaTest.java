package com.renny.joblogger.repository;

import com.renny.joblogger.JobLoggerApp;
import com.renny.joblogger.domain.LoggerEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {JobLoggerApp.class})
public class LoggerJpaTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void mappingOk() {
        LoggerEntity entity = this.tem.persistAndFlush(new LoggerEntity(null, "1,HOLA MUNDO", "com.renny.joblogger.component.LogToDatabaseComponent"));
        Assertions.assertThat(entity.getId()).isGreaterThan(0);
        Assertions.assertThat(entity.getMessage()).isEqualToIgnoringCase("1,HOLA MUNDO");
        Assertions.assertThat(entity.getName()).isEqualToIgnoringCase("com.renny.joblogger.component.LogToDatabaseComponent");
    }
}
