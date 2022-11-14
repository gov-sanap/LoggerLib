package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.Message;
import com.gsanap.loggerlib.validators.MessageValidator;

public class Utils {

    public static String createMessageLine(Message message) {
        if (MessageValidator.isValid(message)){
            return String.format("%s\t[%s]\t%s -> %s\n", message.getLogLevel(), message.getTimeStamp(), message.getName(), message.getContent());
        }
        System.out.println("message is invalid");
        return null;
    }
}
