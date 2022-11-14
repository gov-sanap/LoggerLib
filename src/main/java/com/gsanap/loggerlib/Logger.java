package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.enums.LogLevel;
import com.gsanap.loggerlib.models.Message;
import com.gsanap.loggerlib.models.configs.LoggerConfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Logger {

    private Map<LogLevel, ISink> logLevelSinkMap;
    private LoggerConfig loggerConfig;
    private ISink defaultSink;

    public Logger(LoggerConfig loggerConfig, Map<LogLevel, ISink> logLevelSinkMap, ISink defaultSink) {
        this.loggerConfig = loggerConfig;
        this.logLevelSinkMap = logLevelSinkMap;
        this.defaultSink = defaultSink;
    }

    public boolean log(LogLevel logLevel, String name, Object content){
        if (logLevel == null){
            logLevel = loggerConfig.getDefaultLogLevel();
        }
        Message message = getMessage(logLevel, name, content);
        ISink sink = logLevelSinkMap.getOrDefault(logLevel, defaultSink);
        return sink.log(message);
    }

    private Message getMessage(LogLevel logLevel, String name, Object content) {
        SimpleDateFormat formatter = new SimpleDateFormat(loggerConfig.getDateFormat());
        String timeStamp = formatter.format(new Date());
        Message message = new Message(logLevel, name, Objects.toString(content), timeStamp);
        return message;
    }
}
