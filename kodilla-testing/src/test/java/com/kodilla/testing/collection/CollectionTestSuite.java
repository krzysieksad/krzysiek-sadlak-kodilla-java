package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CollectionTestSuite {
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> empty = exterminator.exterminate(new ArrayList<>());
        Assert.assertEquals(empty, new ArrayList<Integer>());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(13,15,38,42,1,48,31,6,418,31,546,187,851,68,41864,18,64,8,641,985));
        List<Integer> onlyEven = exterminator.exterminate(randomNumbers);
        Assert.assertEquals(onlyEven, Arrays.asList(38,42,48,6,418,546,68,41864,18,64,8));
    }

    @Before
    public void before() {
        System.out.println("Beginning of test case.");
    }

    @After
    public void after() {
        System.out.println("End of test case.");
    }
}
