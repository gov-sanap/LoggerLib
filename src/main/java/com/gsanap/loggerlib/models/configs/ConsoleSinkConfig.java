package com.gsanap.loggerlib.models.configs;

import com.gsanap.loggerlib.models.enums.SinkType;

public class ConsoleSinkConfig extends SinkConfig {

    public ConsoleSinkConfig(){
        this.setSinkType(SinkType.CONSOLE);
    }
}
