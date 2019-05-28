package com.renny.joblogger.dto;

import com.renny.joblogger.model.LogLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogMessageDTO implements Serializable {
    private static final long serialVersionUID = -8624528182950433680L;
    private String message;
    private LogLevel level;
}
