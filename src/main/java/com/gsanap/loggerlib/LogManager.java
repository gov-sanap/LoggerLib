package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.enums.LogLevel;
import com.gsanap.loggerlib.models.configs.LoggerConfig;
import com.gsanap.loggerlib.models.configs.SinkConfig;

import java.util.HashMap;
import java.util.Map;

public class LogManager {

    /*
        Console application
     */
    public static Logger getLogger(LoggerConfig loggerConfig){

        Map<LogLevel, SinkConfig> logLevelSinkConfigMap = loggerConfig.getLogLevelSinkConfigMap();
        Map<LogLevel, ISink> logLevelSinkMap = new HashMap<>();
        logLevelSinkConfigMap.forEach((logLevel, sinkConfiguration) -> logLevelSinkMap.put(logLevel, SinkFactory.getSink(sinkConfiguration)));

        ISink defaultSink = SinkFactory.getSink(loggerConfig.getDefaultSinkConfig());

        return new Logger(loggerConfig, logLevelSinkMap, defaultSink);
    }
}
