package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.configs.FileSinkConfig;
import com.gsanap.loggerlib.models.configs.SinkConfig;
import com.gsanap.loggerlib.models.sink.ConsoleSink;
import com.gsanap.loggerlib.models.sink.FileSink;

public class SinkFactory {

    public static ISink getSink(SinkConfig sinkConfig){

        switch (sinkConfig.getSinkType()){
            case FILE: return new FileSink((FileSinkConfig) sinkConfig);
            default: return new ConsoleSink(sinkConfig);
        }
    }
}
