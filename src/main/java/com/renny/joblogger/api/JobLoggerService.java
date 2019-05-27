package com.renny.joblogger.api;

import com.renny.joblogger.dto.LogMessageDTO;

public interface JobLoggerService {
    boolean write(LogMessageDTO message);
}
