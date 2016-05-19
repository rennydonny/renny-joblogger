package com.renny.joblogger.component.impl;

import com.renny.joblogger.component.LogOutputComponent;
import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@Component("logToConsoleComponent")
public class LogToConsoleComponent extends LoggerAbstract implements LogOutputComponent {

    @Override
    protected Handler getHandlerType() {
        return new ConsoleHandler();
    }
}
