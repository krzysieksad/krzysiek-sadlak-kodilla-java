package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    /**
     * Submodule 8.4.
     * @param args args
     */
    public static void main(final String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message was not sent, but my program is still running very well!");
        }
        System.out.println("Processing other logic!");
    }
}
