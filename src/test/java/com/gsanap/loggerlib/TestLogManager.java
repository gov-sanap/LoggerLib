package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.enums.LogLevel;
import com.gsanap.loggerlib.models.configs.FileSinkConfig;
import com.gsanap.loggerlib.models.configs.LoggerConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLogManager {

    @Test
    public void testDefaultConfig(){

        LoggerConfig loggerConfig = new LoggerConfig("dd/MM/yyyy HH:mm:ss");

        Logger logger = LogManager.getLogger(loggerConfig);
        Assertions.assertTrue(logger.log(LogLevel.DEBUG, "name of origin", "Content of log"));
    }

    @Test
    public void testCustomConfig(){

        LoggerConfig loggerConfig = new LoggerConfig("dd/MM/yyyy HH:mm:ss");
        loggerConfig.addLogLevel(LogLevel.DEBUG, new FileSinkConfig("sample.log", 12L));

        Logger logger = LogManager.getLogger(loggerConfig);
        logger.log(LogLevel.DEBUG, "name of origin", "Content of log");
    }

}
