package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.information.EmailSender;
import com.kodilla.good.patterns.challenges.items.Game;
import com.kodilla.good.patterns.challenges.misc.OrderRequest;
import com.kodilla.good.patterns.challenges.misc.Orders;
import com.kodilla.good.patterns.challenges.misc.User;
import com.kodilla.good.patterns.challenges.repositories.ElectronicsRepository;
import com.kodilla.good.patterns.challenges.service.GameOrder;

public class Application {
    /**
     * Task 9.2.
     * @param args args
     */
    public static void main(final String[] args) {
        Orders orderQueue = new Orders();
        orderQueue.addOrder(new OrderRequest(new User("NewUser", "new_user@kodilla.com.pl", "+48512250069"),
                new Game("Carmageddon", 6.66)));

        ProductOrderService productOrderService = new ProductOrderService(new EmailSender(), new GameOrder(), new ElectronicsRepository());
        productOrderService.process(orderQueue.getNextOrder());
    }
}
