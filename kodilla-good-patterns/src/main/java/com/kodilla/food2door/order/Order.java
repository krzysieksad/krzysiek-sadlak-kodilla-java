package com.kodilla.food2door.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<SingleOrder> orderList = new ArrayList<>();

    public void addToList(final SingleOrder singleOrder) {
        orderList.add(singleOrder);
    }

    public List<SingleOrder> showOrderList() {
        return new ArrayList<>(orderList);
    }
}
