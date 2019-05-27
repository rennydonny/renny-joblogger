package com.renny.joblogger;

import com.renny.joblogger.model.LogLevel;
import com.renny.joblogger.model.LogOutputType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "logger")
public class LoggerProperties {
    @Getter @Setter private List<LogLevel> levels;
    @Getter @Setter private List<LogOutputType> outputs;
}
