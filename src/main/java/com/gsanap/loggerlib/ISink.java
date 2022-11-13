package com.gsanap.loggerlib;

import com.gsanap.loggerlib.models.Message;

public interface ISink {

    public boolean log(Message message);
    public void logAsync(Message message);

}
