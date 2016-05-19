package com.renny.joblogger.enums;

/**
 * Created by renrodriguez on 5/3/2016.
 */
public enum LogOutputTypes {

    CONSOLE("LTC"),
    FILE("LTF"),
    DATABASE("LTD");

    private String output;

    LogOutputTypes(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
