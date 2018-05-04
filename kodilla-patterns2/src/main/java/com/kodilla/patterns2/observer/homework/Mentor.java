package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentor;
    private int updateCount;

    public Mentor(final String mentor) {
        this.mentor = mentor;
    }

    @Override
    public void update(final TasksForMentor tasksForMentor) {
        System.out.println(mentor + ": New tasks from " + tasksForMentor.getParticipantName());
        updateCount++;
    }

    public String getMentor() {
        return mentor;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public String getNextTaskFromParticipant(final TasksForMentor tasksForMentor) {
        return tasksForMentor.getTasks().poll();
    }
}
