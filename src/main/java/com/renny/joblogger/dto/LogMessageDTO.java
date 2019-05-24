package com.renny.joblogger.dto;

import com.renny.joblogger.model.LogLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogMessageDTO {
    private String message;
    private LogLevel level;
}