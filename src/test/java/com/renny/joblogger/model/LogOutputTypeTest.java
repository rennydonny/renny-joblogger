package com.renny.joblogger.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LogOutputTypeTest {
    @Test
    public void logOutputTypeShouldBeExists(){
        Assertions.assertThat(LogOutputType.CONSOLE).isNotNull();
        Assertions.assertThat(LogOutputType.DATABASE).isNotNull();
        Assertions.assertThat(LogOutputType.FILE).isNotNull();
    }

}