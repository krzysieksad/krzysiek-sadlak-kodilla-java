package com.kodilla.exception.nullpointer;

public class MessageSender {
    /**
     * Send message.
     * @param user addressee
     * @param message message text
     */
    public void sendMessageTo(final User user, final String message) throws MessageNotSentException {
        if (user != null) {
            System.out.println("Sending message: " + message + " to " + user.getName());
        }
        throw new MessageNotSentException("Object User was null");
    }
}
