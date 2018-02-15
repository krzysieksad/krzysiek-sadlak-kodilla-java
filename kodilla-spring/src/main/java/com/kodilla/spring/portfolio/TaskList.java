package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<String> tasks;

    TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTaskToList(final String task) {
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}
