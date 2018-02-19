package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShopping() {
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task shopping = factory.createTask(TaskFactory.SHOP);

        //then
        Assert.assertEquals("Shopping", shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task painting = factory.createTask(TaskFactory.PAINT);
        painting.executeTask();

        //then
        Assert.assertEquals("Painting", painting.getTaskName());
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDriving() {
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task driving = factory.createTask(TaskFactory.DRIVE);
        driving.executeTask();
        boolean executeSecondTime = driving.executeTask();

        //then
        Assert.assertEquals("Driving", driving.getTaskName());
        Assert.assertTrue(driving.isTaskExecuted());
        Assert.assertFalse(executeSecondTime);
    }
}
