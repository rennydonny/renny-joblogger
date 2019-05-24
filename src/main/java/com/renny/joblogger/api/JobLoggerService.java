package com.renny.joblogger.api;

import com.renny.joblogger.dtos.LogMessageDTO;

public interface JobLoggerService {
    void write(LogMessageDTO message);
}
