package com.kodilla.patterns.factory.tasks;

public interface Task {
    boolean executeTask();

    TaskFactory.TaskTypes getTaskName();

    boolean isTaskExecuted();
}
