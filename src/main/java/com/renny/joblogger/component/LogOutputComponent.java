package com.renny.joblogger.component;

/**
 * Created by renrodriguez on 5/3/2016.
 */
public interface LogOutputComponent {

    void writeLog(String message, String logLevel) throws Exception;
}
