package com.renny.joblogger.component;

import com.renny.joblogger.dtos.LogMessageDTO;

/**
 * Created by renrodriguez on 5/3/2016.
 */
public interface LogOutputComponent {
    void push(LogMessageDTO logMessage);
}
