package com.gsanap.loggerlib.models.configs;

import com.gsanap.loggerlib.models.enums.LogLevel;

import java.util.HashMap;
import java.util.Map;

public class LoggerConfig {

    private String dateFormat;
    private LogLevel defaultLogLevel = LogLevel.INFO;
    private SinkConfig defaultSinkConfig = new ConsoleSinkConfig();
    private Map<LogLevel, SinkConfig> logLevelSinkConfigMap = new HashMap<>();

    public LoggerConfig() {
        this.dateFormat = "dd/MM/yyyy HH:mm:ss";
    }

    public LoggerConfig(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public LoggerConfig(String dateFormat, SinkConfig defaultSinkConfig) {
        this.dateFormat = dateFormat;
        this.defaultSinkConfig = defaultSinkConfig;
    }

    public void addLogLevel(LogLevel logLevel, SinkConfig sinkConfig){
        this.logLevelSinkConfigMap.put(logLevel, sinkConfig);
    }

    public LogLevel getDefaultLogLevel() {
        return defaultLogLevel;
    }

    public SinkConfig getDefaultSinkConfig() {
        return defaultSinkConfig;
    }

    public Map<LogLevel, SinkConfig> getLogLevelSinkConfigMap() {
        return logLevelSinkConfigMap;
    }

    public String getDateFormat() {
        return dateFormat;
    }
}
