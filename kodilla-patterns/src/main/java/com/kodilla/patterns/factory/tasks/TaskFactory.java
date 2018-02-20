package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public enum TaskTypes {
        SHOPPING_TASK,
        PAINTING_TASK,
        DRIVING_TASK
    }

    /**
     * Task 11.4. Creating tasks.
     *
     * @param task taskClass
     * @return Task
     */
    public Task createTask(final TaskTypes task) {
        switch (task) {
            case SHOPPING_TASK:
                return new ShoppingTask(TaskTypes.SHOPPING_TASK, "toys", 153);
            case PAINTING_TASK:
                return new PaintingTask(TaskTypes.PAINTING_TASK, "black", "Sleeping room");
            case DRIVING_TASK:
                return new DrivingTask(TaskTypes.DRIVING_TASK, "Warsaw", "Train");
            default:
                throw new IllegalArgumentException();
        }
    }
}
