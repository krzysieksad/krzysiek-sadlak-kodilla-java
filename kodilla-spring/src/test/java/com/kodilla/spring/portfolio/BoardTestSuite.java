package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        TaskList taskList1 = (TaskList) context.getBean("taskList1");
        taskList1.addTaskToList("task1");
        TaskList taskList2 = (TaskList) context.getBean("taskList2");
        taskList2.addTaskToList("task2");
        TaskList taskList3 = (TaskList) context.getBean("taskList3");
        taskList3.addTaskToList("task3");

        //when
        List<String> tasks1 = board.getToDoList().getTasks();
        List<String> tasks2 = board.getInProgressList().getTasks();
        List<String> tasks3 = board.getDoneList().getTasks();

        //then
        Assert.assertEquals(Arrays.asList("task1"), tasks1);
        Assert.assertEquals(Arrays.asList("task2"), tasks2);
        Assert.assertEquals(Arrays.asList("task3"), tasks3);

    }
}
