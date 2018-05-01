package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParticipantTasksTestSuite {
    @Test
    public void testUpdate() {
        //given
        Mentor mentor1 = new Mentor("mentor1");
        Mentor mentor2 = new Mentor("mentor2");
        ParticipantTasks participant1 = new ParticipantTasks("participant1");
        ParticipantTasks participant2 = new ParticipantTasks("participant2");
        ParticipantTasks participant3 = new ParticipantTasks("participant3");
        ParticipantTasks participant4 = new ParticipantTasks("participant4");
        ParticipantTasks participant5 = new ParticipantTasks("participant5");
        participant1.registerObserver(mentor1);
        participant2.registerObserver(mentor1);
        participant3.registerObserver(mentor2);
        participant4.registerObserver(mentor2);
        participant5.registerObserver(mentor2);
        participant4.registerObserver(mentor1);

        //when
        participant1.addTask("task1");
        participant1.addTask("task2");
        participant1.addTask("task3");
        participant1.addTask("task4");
        participant2.addTask("task1");
        participant2.addTask("task2");
        participant3.addTask("task1");
        participant3.addTask("task2");
        participant3.addTask("task3");
        participant3.addTask("task4");
        participant4.addTask("task1");
        participant4.addTask("task2");
        participant4.addTask("task3");
        participant4.addTask("task4");
        participant4.addTask("task5");
        participant4.addTask("task6");
        participant5.addTask("task1");
        participant5.addTask("task2");
        participant5.addTask("task3");
        participant5.addTask("task4");

        //then
        assertEquals(12, mentor1.getUpdateCount());
        assertEquals(14, mentor2.getUpdateCount());
    }
}