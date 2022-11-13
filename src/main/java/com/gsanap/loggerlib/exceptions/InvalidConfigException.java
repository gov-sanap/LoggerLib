package com.gsanap.loggerlib.exceptions;

public class InvalidConfigException extends Exception {

    public InvalidConfigException(String message){
        super(message);
    }

    public InvalidConfigException(String message, Exception exception){
        super(message, exception);
    }

}
