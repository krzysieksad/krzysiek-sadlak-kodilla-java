package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

import static com.kodilla.patterns.factory.tasks.TaskFactory.TaskTypes.SHOPPING_TASK;
import static com.kodilla.patterns.factory.tasks.TaskFactory.TaskTypes.PAINTING_TASK;
import static com.kodilla.patterns.factory.tasks.TaskFactory.TaskTypes.DRIVING_TASK;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShopping() {
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task shopping = factory.createTask(SHOPPING_TASK);

        //then
        Assert.assertEquals(SHOPPING_TASK, shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task painting = factory.createTask(PAINTING_TASK);
        painting.executeTask();

        //then
        Assert.assertEquals(PAINTING_TASK, painting.getTaskName());
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDriving() {
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task driving = factory.createTask(DRIVING_TASK);
        driving.executeTask();
        boolean executeSecondTime = driving.executeTask();

        //then
        Assert.assertEquals(DRIVING_TASK, driving.getTaskName());
        Assert.assertTrue(driving.isTaskExecuted());
        Assert.assertFalse(executeSecondTime);
    }
}
