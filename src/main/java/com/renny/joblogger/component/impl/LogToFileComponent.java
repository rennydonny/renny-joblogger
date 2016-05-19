package com.renny.joblogger.component.impl;

import com.renny.joblogger.component.LogOutputComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

/**
 * Created by renrodriguez on 5/3/2016.
 */
@Component("logToFileComponent")
public class LogToFileComponent extends LoggerAbstract implements LogOutputComponent {

    private FileHandler fileHandler;

    @Value("/home/redo/logs/apps")
    private String directory;

    @Override
    protected Handler getHandlerType() {
        try{
            String filePath = String.format("%s/logFile.txt", directory);
            File logFile = new File(filePath);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            fileHandler = new FileHandler(filePath,1000000,1);
            fileHandler.setFormatter(new SimpleFormatter());

        }catch (IOException e){
            e.printStackTrace();
        }
        return fileHandler;
    }
}
