package com.renny.joblogger.component;

import com.renny.joblogger.dto.LogMessageDTO;

public interface LogOutputComponent {
    void push(LogMessageDTO logMessage);
}
