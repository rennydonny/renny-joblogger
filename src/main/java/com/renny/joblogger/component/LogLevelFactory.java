package com.renny.joblogger.component;

import com.renny.joblogger.enums.LogLevelTypes;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@Component
public class LogLevelFactory {

    HashMap<String,LogLevelTypes> levelHashMap = new HashMap<>();

    public LogLevelFactory() {
        levelHashMap.put("WARN", LogLevelTypes.WARN);
        levelHashMap.put("INFO",LogLevelTypes.INFO);
        levelHashMap.put("ERROR",LogLevelTypes.ERROR);
    }

    public LogLevelTypes getLogLevel(String type){
        return levelHashMap.get(type);
    }
}
