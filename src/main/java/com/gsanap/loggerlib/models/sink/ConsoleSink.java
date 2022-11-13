package com.gsanap.loggerlib.models.sink;

import com.gsanap.loggerlib.ISink;
import com.gsanap.loggerlib.models.Message;
import com.gsanap.loggerlib.Utils;
import com.gsanap.loggerlib.models.configs.SinkConfig;

public class ConsoleSink implements ISink {

    private SinkConfig sinkConfig;

    public ConsoleSink(SinkConfig sinkConfig) {
    }

    @Override
    public boolean log(Message message) {
        String messageLine = Utils.createMessageLine(message);
        System.out.println(messageLine);
        return true;
    }

    @Override
    public void logAsync(Message message) {

    }

}
