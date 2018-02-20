package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final TaskFactory.TaskTypes taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isTaskExecuted = false;

    /**
     * Task 11.4. Shopping.
     *
     * @param taskName  name
     * @param whatToBuy product
     * @param quantity  quantity
     */
    public ShoppingTask(final TaskFactory.TaskTypes taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    /**
     * Execute task if it's not executed yet.
     *
     * @return isDone
     */
    public boolean executeTask() {
        if (!isTaskExecuted) {
            isTaskExecuted = true;
            System.out.println(quantity + " of " + whatToBuy + " bought.");
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
