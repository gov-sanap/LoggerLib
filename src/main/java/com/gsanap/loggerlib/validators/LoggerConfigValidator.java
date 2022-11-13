package com.gsanap.loggerlib.validators;

import com.gsanap.loggerlib.exceptions.InvalidConfigException;
import com.gsanap.loggerlib.models.configs.FileSinkConfig;
import com.gsanap.loggerlib.models.configs.LoggerConfig;
import com.gsanap.loggerlib.models.enums.SinkType;

import javax.xml.validation.Validator;
import java.text.SimpleDateFormat;

public class LoggerConfigValidator {

    public static boolean isValid(LoggerConfig loggerConfig) throws InvalidConfigException {

        if (loggerConfig == null){
            return false;
        }
        String dateFormat = loggerConfig.getDateFormat();
        if (dateFormat == null || dateFormat.isEmpty()){
            return false;
        }
        try {
            new SimpleDateFormat(dateFormat);
        }
        catch (IllegalArgumentException exception){
            throw new InvalidConfigException("Invalid date Format", exception);
        }
        if (loggerConfig.getDefaultLogLevel() == null){
            return false;
        }
        if (loggerConfig.getDefaultSinkConfig() == null){
            return false;
        }

        return true;
    }
}
