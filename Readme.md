Following are the steps to use this library

1. Simple use with consoleLogSink
```java
        LoggerConfig loggerConfig = new LoggerConfig("dd/MM/yyyy HH:mm:ss");
        Logger logger = LogManager.getLogger(loggerConfig);
        Assertions.assertTrue(logger.log(LogLevel.DEBUG, "name of origin", "Content of log"));
```

2. More customized approach

   * Create basic LoggerConfig object using constructor.
   * Create SinkConfiguration objects for all the sinks that you want to use.
       ex:-
     ```java 
     FileSinkConfig fileSinkConfig = new FileSinkConfig("sample.log", 12L)
       ```

   * Now you will have to addLogLevel to loggerConfig object to with sinkConfig of your desired choice.
   * Once the loggerConfig object is ready create Logger object using LogManager.getLogger method.
   * Now you can use logger object to log any message.
   

    Following is one complete example.
    ```java
            LoggerConfig loggerConfig = new LoggerConfig("dd/MM/yyyy HH:mm:ss");
            
            loggerConfig.addLogLevel(LogLevel.DEBUG, new ConsoleSinkConfig());
            loggerConfig.addLogLevel(LogLevel.INFO, new FileSinkConfig("info.log", 25000l));
            loggerConfig.addLogLevel(LogLevel.WARN, new FileSinkConfig("warn.log", 12000l));
            loggerConfig.addLogLevel(LogLevel.ERROR, new FileSinkConfig("error.log", 12000l));
            loggerConfig.addLogLevel(LogLevel.FATAL, new FileSinkConfig("fatal.log", 12000l));
    
            Logger logger = LogManager.getLogger(loggerConfig);
            
            logger.log(LogLevel.DEBUG, "name of origin", "Content of log");
            logger.log(LogLevel.INFO, "name of origin", "some info of log");
            logger.log(LogLevel.WARN, "name of origin", "warning message of log");
            logger.log(LogLevel.ERROR, "name of origin", new Exception("this is sample exception"));
            logger.log(LogLevel.FATAL, "name of origin", "FATAL error type of log");
    ```