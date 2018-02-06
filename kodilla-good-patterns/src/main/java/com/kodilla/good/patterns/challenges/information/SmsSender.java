package com.kodilla.good.patterns.challenges.information;

import com.kodilla.good.patterns.challenges.misc.User;

public class SmsSender implements OrderInformation {
    @Override
    public void sendOrderInformation(final User user, final String info) {
        System.out.println("Sms sent to " + user.getPhoneNumber() + ": " + info);
    }
}
