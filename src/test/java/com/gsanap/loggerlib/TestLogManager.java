package com.gsanap.loggerlib;

import com.gsanap.loggerlib.exceptions.InvalidConfigException;
import com.gsanap.loggerlib.models.configs.ConsoleSinkConfig;
import com.gsanap.loggerlib.models.enums.LogLevel;
import com.gsanap.loggerlib.models.configs.FileSinkConfig;
import com.gsanap.loggerlib.models.configs.LoggerConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLogManager {

    @Test
    public void testDefaultConfig() throws InvalidConfigException {

        LoggerConfig loggerConfig = new LoggerConfig("dd/MM/yyyy HH:mm:ss");
        Logger logger = LogManager.getLogger(loggerConfig);
        Assertions.assertTrue(logger.log(LogLevel.DEBUG, "name of origin", "Content of log"));
    }

    /**
     * This test should not throw any exception
     */
    @Test
    public void testCompleteFlow() throws InvalidConfigException {

        LoggerConfig loggerConfig = new LoggerConfig("dd/MM/yyyy HH:mm:ss");
        loggerConfig.addLogLevel(LogLevel.DEBUG, new ConsoleSinkConfig());
        loggerConfig.addLogLevel(LogLevel.INFO, new FileSinkConfig("info.log", 25000l));
        loggerConfig.addLogLevel(LogLevel.WARN, new FileSinkConfig("warn.log", 12000l));
        loggerConfig.addLogLevel(LogLevel.ERROR, new FileSinkConfig("error.log", 12000l));
        loggerConfig.addLogLevel(LogLevel.FATAL, new FileSinkConfig("fatal.log", 12000l));

        Logger logger = LogManager.getLogger(loggerConfig);
        Assertions.assertTrue(logger.log(LogLevel.DEBUG, "name of origin", "Content of log"));
        Assertions.assertTrue(logger.log(LogLevel.INFO, "name of origin", "some info of log"));
        Assertions.assertTrue(logger.log(LogLevel.WARN, "name of origin", "warning message of log"));
        Assertions.assertTrue(logger.log(LogLevel.ERROR, "name of origin", new Exception("this is sample exception")));
        Assertions.assertTrue(logger.log(LogLevel.FATAL, "name of origin", "FATAL error type of log"));
    }

}
