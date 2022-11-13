package com.gsanap.loggerlib.validators;

import com.gsanap.loggerlib.models.Message;

public class MessageValidator {

    public static boolean isValid(Message message){
        if (message.getLogLevel() == null || message.getName() == null || message.getContent() == null || message.getTimeStamp() == null){
            return false;
        }
        return true;
    }
}
