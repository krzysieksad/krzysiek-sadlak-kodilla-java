package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOP = "ShoppingTask";
    public static final String PAINT = "PaintingTask";
    public static final String DRIVE = "DrivingTask";

    /**
     * Task 11.4. Creating tasks.
     * @param task taskClass
     * @return Task
     */
    public Task createTask(final String task) {
        switch (task) {
            case SHOP:
                return new ShoppingTask("Shopping", "toys", 153);
            case PAINT:
                return new PaintingTask("Painting", "black", "Sleeping room");
            case DRIVE:
                return new DrivingTask("Driving", "Warsaw", "Train");
            default:
                return null;
        }
    }
}
