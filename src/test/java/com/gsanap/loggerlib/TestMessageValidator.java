package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.Message;
import com.gsanap.loggerlib.models.enums.LogLevel;
import com.gsanap.loggerlib.validators.MessageValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMessageValidator {

    @Test
    public void TestMessageIsValid(){
        Message message = new Message(null, "name of origin", "Content of log", "13/11/2022 23:50:13");
        Assertions.assertFalse(MessageValidator.isValid(message));
        message = new Message(LogLevel.INFO, null, "Content of log", "13/11/2022 23:50:13");
        Assertions.assertFalse(MessageValidator.isValid(message));
        message = new Message(LogLevel.INFO, "name of origin", null, "13/11/2022 23:50:13");
        Assertions.assertFalse(MessageValidator.isValid(message));
        message = new Message(LogLevel.INFO, "name of origin", "Content of log", null);
        Assertions.assertFalse(MessageValidator.isValid(message));

        message = new Message(LogLevel.INFO, "name of origin", "Content of log", "13/11/2022 23:50:13");
        Assertions.assertTrue(MessageValidator.isValid(message));
    }
}
