package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.Observer;

public class Mentor implements Observer {
    private final String mentor;
    private int updateCount;

    public Mentor(final String mentor) {
        this.mentor = mentor;
    }

    @Override
    public void update(final ParticipantTasks participantTasks) {
        System.out.println(mentor + ": New tasks from " + forumTopic.getName() + "\n" + " (total: " + forumTopic.getMessages().size() + " messages)");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
