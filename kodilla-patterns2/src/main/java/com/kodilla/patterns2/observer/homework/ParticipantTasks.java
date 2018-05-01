package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ParticipantTasks implements Observable {
    private final List<Observer> observers;
    private final String participantName;
    private final Queue<String> tasks;

    /**
     * Task 20.4. Participant tasks.
     *
     * @param participantName participant
     */
    public ParticipantTasks(final String participantName) {
        this.observers = new ArrayList<>();
        this.participantName = participantName;
        this.tasks = new ArrayDeque<>();
    }

    public String getParticipantName() {
        return participantName;
    }

    public Queue<String> getTasks() {
        return tasks;
    }

    public void addTask(final String task) {
        tasks.offer(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }
}
