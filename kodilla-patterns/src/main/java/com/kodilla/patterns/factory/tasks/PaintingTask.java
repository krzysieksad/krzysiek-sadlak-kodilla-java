package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private final TaskFactory.TaskTypes taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isTaskExecuted = false;

    /**
     * Task 11.4. Painting.
     *
     * @param taskName    name
     * @param color       color
     * @param whatToPaint place
     */
    public PaintingTask(final TaskFactory.TaskTypes taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    /**
     * Execute task if it's not executed yet.
     *
     * @return isDone
     */
    public boolean executeTask() {
        if (!isTaskExecuted) {
            isTaskExecuted = true;
            System.out.println(whatToPaint + " painted " + color + ".");
            return true;
        } else {
            return false;
        }
    }

    public TaskFactory.TaskTypes getTaskName() {
        return taskName;
    }

    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
