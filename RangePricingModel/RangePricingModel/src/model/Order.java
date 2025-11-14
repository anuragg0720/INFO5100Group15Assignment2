package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public OrderItem addOrderItem(Product product, int quantity, double actualPrice) {
        OrderItem oi = new OrderItem(this, product, quantity, actualPrice);
        orderItems.add(oi);
        return oi;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }
}
