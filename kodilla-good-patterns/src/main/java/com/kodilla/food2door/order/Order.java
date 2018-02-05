package com.kodilla.food2door.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<SingleOrder> orderList = new ArrayList<>();

    public boolean addToList(final SingleOrder singleOrder) {
        return true;
    }

    public boolean removeFromList(final SingleOrder singleOrder) {
        return true;
    }

    public List<SingleOrder> showOrderList() {
        return new ArrayList<>(orderList);
    }
}
