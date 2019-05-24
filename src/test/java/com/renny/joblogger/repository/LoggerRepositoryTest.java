package com.renny.joblogger.repository;

import com.renny.joblogger.domain.LoggerEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoggerRepositoryTest {
    @Autowired
    private LoggerRepository repository;

    @Test
    public void saveIsOk() {
        this.repository.save(new LoggerEntity(null,"1,HOLA MUNDO","com.renny.joblogger.component.LogToDatabaseComponent"));
        Optional<LoggerEntity> byId = this.repository.findById(1L);
        Assertions.assertThat(byId.isPresent()).isTrue();
    }
}