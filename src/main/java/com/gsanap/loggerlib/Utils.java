package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.Message;

public class Utils {

    public static String createMessageLine(Message message) {
        return String.format("%s\t[%s]\t%s -> %s\n",message.getLogLevel(),message.getTimeStamp(),message.getName(),message.getContent());
    }
}
