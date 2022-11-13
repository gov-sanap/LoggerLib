package com.gsanap.loggerlib.models.configs;

import com.gsanap.loggerlib.models.enums.SinkType;

public class FileSinkConfig extends SinkConfig {

    private String fileLocation;
    private Long maxFileSizeInBytes;


    public FileSinkConfig(String fileLocation, Long maxFileSizeInBytes) {
        this.setSinkType(SinkType.FILE);
        this.fileLocation = fileLocation;
        this.maxFileSizeInBytes = maxFileSizeInBytes;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public Long getMaxFileSizeInBytes() {
        return maxFileSizeInBytes;
    }
}
