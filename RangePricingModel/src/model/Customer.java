package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public Order newOrder() {
        Order o = new Order(this);
        orders.add(o);
        return o;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
