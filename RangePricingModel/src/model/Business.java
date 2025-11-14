package model;

public class Business {
    private SupplierDirectory supplierDirectory;
    private CustomerDirectory customerDirectory;

    public Business() {
        this.supplierDirectory = new SupplierDirectory();
        this.customerDirectory = new CustomerDirectory();
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }
}
