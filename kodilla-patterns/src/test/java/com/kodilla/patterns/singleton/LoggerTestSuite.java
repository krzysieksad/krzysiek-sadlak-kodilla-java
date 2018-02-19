package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void getLastLog() {
        //given

        //when
        Logger.getInstance().log("New log line.");

        //then
        Assert.assertEquals("New log line.", Logger.getInstance().getLastLog());
    }
}
