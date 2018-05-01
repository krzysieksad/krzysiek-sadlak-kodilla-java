package com.kodilla.patterns2.observer.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements Observable {
    private final List<Observer> observers;
    private final List<String> messages;
    private final String name;

    /**
     * Submodule 20.4. Forum.
     *
     * @param name forum topic name
     */
    public ForumTopic(final String name) {
        this.observers = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.name = name;
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

    public void addPost(final String post) {
        messages.add(post);
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
