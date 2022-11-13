package com.gsanap.loggerlib.models.configs;

import com.gsanap.loggerlib.models.enums.SinkType;

public class SinkConfig {
    
    private SinkType sinkType;

    public SinkType getSinkType() {
        return sinkType;
    }

    protected void setSinkType(SinkType sinkType) {
        this.sinkType = sinkType;
    }
}
