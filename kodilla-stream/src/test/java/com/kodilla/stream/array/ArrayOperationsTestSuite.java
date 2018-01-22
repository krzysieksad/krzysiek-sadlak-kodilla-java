package com.kodilla.stream.array;

import java.util.OptionalDouble;
import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //given
        int[] numbers = {3,4,75,5,43,945,652,76,87,75,413,1,1423,67,65,48,676,65,1,42145,265,63787,68};

        //when
        OptionalDouble average = ArrayOperations.getAverage(numbers);

        //then
        Assert.assertEquals(4825.60869, average.getAsDouble(), 0.00001);
    }
}
