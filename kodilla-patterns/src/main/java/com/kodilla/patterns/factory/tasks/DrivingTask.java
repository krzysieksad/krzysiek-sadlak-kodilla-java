package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean isTaskExecuted = false;

    /**
     * Task 11.4. Driving.
     * @param taskName name
     * @param where destination
     * @param using vehicle
     */
    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    /**
     * Execute task if it's not executed yet.
     * @return isDone
     */
    public boolean executeTask() {
        if (!isTaskExecuted) {
            isTaskExecuted = true;
            System.out.println(using + " drove to " + where + ".");
            return true;
        } else {
            return false;
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
