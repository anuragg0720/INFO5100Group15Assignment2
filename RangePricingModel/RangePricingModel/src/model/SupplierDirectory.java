package model;

import java.util.ArrayList;
import java.util.List;

public class SupplierDirectory {
    private List<Supplier> suppliers = new ArrayList<>();

    public Supplier newSupplier(String name) {
        Supplier s = new Supplier(name);
        suppliers.add(s);
        return s;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }
}
