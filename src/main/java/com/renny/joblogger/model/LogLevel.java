package com.renny.joblogger.model;

import java.util.logging.Level;

public enum LogLevel {
    WARN("3","warning", Level.WARNING),
    ERROR("2","error",Level.SEVERE),
    MESSAGE("1","message",Level.INFO);

    private String category;
    private String description;
    private Level level;

    LogLevel(String category,String description, Level level) {
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
