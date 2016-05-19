package com.renny.joblogger.component.impl;

import com.renny.joblogger.component.LogLevelFactory;
import com.renny.joblogger.enums.LogLevelTypes;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Created by renrodriguez on 5/3/2016.
 */
public abstract class LoggerAbstract {

    protected Logger logger = Logger.getLogger("MyLog");

    @Autowired
    protected LogLevelFactory logLevelFactory;

    public void writeLog(String message, String logLevel) throws Exception{
        logger.addHandler(getHandlerType());
        String format = DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
        LogLevelTypes logLevelTypes = logLevelFactory.getLogLevel(logLevel);
        if(logLevelTypes!=null){
            logger.log(logLevelTypes.getLevel(),String.format("%s %s %s", logLevelTypes.getDescription(), format, message));
        }
    }

    protected abstract Handler getHandlerType();
}
