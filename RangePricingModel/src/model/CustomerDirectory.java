package model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDirectory {
    private List<Customer> customers = new ArrayList<>();

    public Customer newCustomer(String name) {
        Customer c = new Customer(name);
        customers.add(c);
        return c;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
