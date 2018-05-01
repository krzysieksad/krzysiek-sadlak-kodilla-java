package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.Observable;
import com.kodilla.patterns2.observer.homework.Observer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ParticipantTasks implements Observable {
    private final List<Observer> observers;
    private final String participantName;
    private final Queue<String> tasks;

    /**
     *
     * @param participantName
     */
    public ParticipantTasks(final String participantName) {
        this.observers = new ArrayList<>();
        this.participantName = participantName;
        this.tasks = new ArrayDeque<>();
    }
}
