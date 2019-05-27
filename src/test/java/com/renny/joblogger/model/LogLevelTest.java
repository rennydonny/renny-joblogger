package com.renny.joblogger.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.logging.Level;

public class LogLevelTest {
    @Test
    public void logLevelsShouldBeExists(){
        LogLevel error = LogLevel.ERROR;
        LogLevel message = LogLevel.MESSAGE;
        LogLevel warn = LogLevel.WARN;
        Assertions.assertThat(error.getLevel()).isInstanceOf(Level.class);
        Assertions.assertThat(error.getCategory()).isEqualTo("2");
        Assertions.assertThat(error.getDescription()).isEqualTo("error");
        Assertions.assertThat(error).isNotNull();
        Assertions.assertThat(message.getLevel()).isInstanceOf(Level.class);
        Assertions.assertThat(message.getCategory()).isEqualTo("1");
        Assertions.assertThat(message.getDescription()).isEqualTo("message");
        Assertions.assertThat(message).isNotNull();
        Assertions.assertThat(warn.getLevel()).isInstanceOf(Level.class);
        Assertions.assertThat(warn.getCategory()).isEqualTo("3");
        Assertions.assertThat(warn.getDescription()).isEqualTo("warning");
        Assertions.assertThat(warn).isNotNull();
    }

}