package com.renny.joblogger.api;

import com.renny.joblogger.dto.LogMessageDTO;

public interface JobLoggerService {
    void write(LogMessageDTO message);
}
