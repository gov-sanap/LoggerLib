package com.gsanap.loggerlib.models;

import com.gsanap.loggerlib.models.enums.LogLevel;

public class Message {

    private String content;
    private LogLevel logLevel;
    private String name;
    private String timeStamp;



    public Message(LogLevel logLevel, String name, String content, String timeStamp) {
        this.logLevel = logLevel;
        this.name = name;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
