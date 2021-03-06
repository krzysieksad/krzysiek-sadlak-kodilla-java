package com.kodilla.good.patterns.challenges.information;

import com.kodilla.good.patterns.challenges.misc.User;

public class EmailSender implements OrderInformation {
    @Override
    public void sendOrderInformation(final User user, final String info) {
        System.out.println("Email sent to " + user.getEmail() + ": " + info);
    }
}
