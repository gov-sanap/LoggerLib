package com.gsanap.loggerlib;

import com.gsanap.loggerlib.exceptions.InvalidConfigException;
import com.gsanap.loggerlib.models.enums.LogLevel;
import com.gsanap.loggerlib.models.configs.LoggerConfig;
import com.gsanap.loggerlib.models.configs.SinkConfig;
import com.gsanap.loggerlib.validators.LoggerConfigValidator;

import java.util.HashMap;
import java.util.Map;

public class LogManager {

    /**
     * This method will return Logger object which can be used to log messages.
     *
     * @param loggerConfig : basic logger configuration object with details like dateFormat, logLevel to SinkConfiguration map.
     */
    public static Logger getLogger(LoggerConfig loggerConfig) throws InvalidConfigException {
        if (LoggerConfigValidator.isValid(loggerConfig)){
            Map<LogLevel, SinkConfig> logLevelSinkConfigMap = loggerConfig.getLogLevelSinkConfigMap();
            Map<LogLevel, ISink> logLevelSinkMap = new HashMap<>();
            logLevelSinkConfigMap.forEach((logLevel, sinkConfiguration) -> logLevelSinkMap.put(logLevel, SinkFactory.getSink(sinkConfiguration)));

            ISink defaultSink = SinkFactory.getSink(loggerConfig.getDefaultSinkConfig());

            return new Logger(loggerConfig, logLevelSinkMap, defaultSink);
        }
        throw  new InvalidConfigException("Something is wrong with logger configurations");
    }
}
