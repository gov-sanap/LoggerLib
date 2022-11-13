package com.gsanap.loggerlib.models.sink;

import com.gsanap.loggerlib.ISink;
import com.gsanap.loggerlib.models.Message;
import com.gsanap.loggerlib.Utils;
import com.gsanap.loggerlib.models.configs.FileSinkConfig;

import java.io.FileWriter;

public class FileSink implements ISink {

    private FileSinkConfig sinkConfig;

    public FileSink(FileSinkConfig sinkConfig){
        this.sinkConfig = sinkConfig;
    }

    @Override
    public boolean log(Message message) {
        String messageLine = Utils.createMessageLine(message);
        try {
            String fileName = sinkConfig.getFileLocation();
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(messageLine);
            fileWriter.close();
        }
        catch (Exception exception){
            System.out.println(exception);
            return false;
        }
        return true;
    }

    @Override
    public void logAsync(Message message) {

    }


}
