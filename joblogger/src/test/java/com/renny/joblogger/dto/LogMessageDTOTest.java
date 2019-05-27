package com.renny.joblogger.dto;

import com.renny.joblogger.model.LogLevel;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.logging.Level;

public class LogMessageDTOTest {
    @Test
    public void messageDtoShouldBeCreated() {
        LogMessageDTO dto = new LogMessageDTO("HELLO WORLD!", LogLevel.ERROR);
        Assertions.assertThat(dto.getMessage()).isEqualToIgnoringCase("HELLO WORLD!");
        Assertions.assertThat(dto.getLevel()).isInstanceOf(LogLevel.class);
        Assertions.assertThat(dto.getLevel().getCategory()).isEqualTo("2");
        Assertions.assertThat(dto.getLevel().getLevel()).isEqualTo(Level.SEVERE);
    }

}