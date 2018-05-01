package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(final Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
