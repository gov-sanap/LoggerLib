package com.gsanap.loggerlib;

import com.gsanap.loggerlib.exceptions.InvalidConfigException;
import com.gsanap.loggerlib.models.configs.LoggerConfig;
import com.gsanap.loggerlib.validators.LoggerConfigValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoggerConfigValidator {

    @Test
    public void TestLoggerConfigIsValid() throws InvalidConfigException {
        // null object -> return false
        LoggerConfig loggerConfig = null;
        Assertions.assertFalse(LoggerConfigValidator.isValid(loggerConfig));

        // dateFormat is null -> return false
        loggerConfig = new LoggerConfig(null);
        Assertions.assertFalse(LoggerConfigValidator.isValid(loggerConfig));

        // dateFormat is default -> return true
        loggerConfig = new LoggerConfig();
        Assertions.assertTrue(LoggerConfigValidator.isValid(loggerConfig));

        //dateFormat is invalid -> should throw InvalidConfigException
        loggerConfig = new LoggerConfig("something weird");
        LoggerConfig finalLoggerConfig = loggerConfig;
        Assertions.assertThrows(InvalidConfigException.class, () ->LoggerConfigValidator.isValid(finalLoggerConfig));

    }
}
