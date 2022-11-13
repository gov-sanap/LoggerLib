package com.gsanap.loggerlib.models.sink;

import com.gsanap.loggerlib.ISink;
import com.gsanap.loggerlib.models.Message;
import com.gsanap.loggerlib.Utils;
import com.gsanap.loggerlib.models.configs.FileSinkConfig;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPOutputStream;

public class FileSink implements ISink {

    private FileSinkConfig sinkConfig;

    public FileSink(FileSinkConfig sinkConfig){
        this.sinkConfig = sinkConfig;
    }

    @Override
    public boolean log(Message message) {
        String messageLine = Utils.createMessageLine(message);
        if (messageLine == null || messageLine.isEmpty()){
            return false;
        }
        try {
            String fileName = sinkConfig.getFileLocation();
            File file = new File(fileName);
            FileWriter fileWriter = null;
            Thread.sleep(10000);
            if (file.exists() && file.length() > sinkConfig.getMaxFileSizeInBytes()){
                Path sourcePath = Paths.get(fileName);
                Path targetPath = getTargetPath(fileName);
                compressGzip(sourcePath,targetPath);
                fileWriter = new FileWriter(fileName, false);
            }
            else {
                fileWriter = new FileWriter(fileName, true);
            }
            fileWriter.append(messageLine);
            fileWriter.close();
        }
        catch (Exception exception){
            System.out.println(exception);
            return false;
        }
        return true;
    }

    private void compressGzip(Path source, Path target) throws IOException {
        try (GZIPOutputStream gos = new GZIPOutputStream(
                new FileOutputStream(target.toFile()))) {
            Files.copy(source, gos);
        }
    }

    private Path getTargetPath(String fileName) {
        int i = 1;
        Path targetPath = Paths.get(fileName + ".gz");
        while (Files.exists(targetPath)){
            targetPath = Paths.get(fileName + i + ".gz");
        }
        return targetPath;
    }

}
