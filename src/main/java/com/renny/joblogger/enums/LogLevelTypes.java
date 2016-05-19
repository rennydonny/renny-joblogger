package com.renny.joblogger.enums;

import java.util.logging.Level;

/**
 * Created by renrodriguez on 5/3/2016.
 */
public enum LogLevelTypes {

    WARN("3","warning", Level.WARNING),
    ERROR("2","error",Level.ALL),
    INFO("1","message",Level.INFO);

    private String category;
    private String description;
    private Level level;

    LogLevelTypes(String category,String description, Level level) {
        this.category = category;
        this.description = description;
        this.level = level;
    }

    public String getCategory() {
        return category;
    }
    public String getDescription(){
        return description;
    }

    public Level getLevel() {
        return level;
    }
}
