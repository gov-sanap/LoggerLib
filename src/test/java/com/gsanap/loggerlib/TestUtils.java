package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.Message;
import com.gsanap.loggerlib.models.enums.LogLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUtils {

    @Test
    public void testCreateMessageLine(){
        Message message = new Message(LogLevel.DEBUG, "name of origin", "Content of log", "13/11/2022 23:50:13");
        Assertions.assertEquals("DEBUG\t[13/11/2022 23:50:13]\tname of origin -> Content of log\n", Utils.createMessageLine(message));
    }

    @Test
    public void testCreateMessageLine_InvalidMessage(){
        Message message = new Message(null, "name of origin", "Content of log", "13/11/2022 23:50:13");
        Assertions.assertEquals(null, Utils.createMessageLine(message));
    }
}
