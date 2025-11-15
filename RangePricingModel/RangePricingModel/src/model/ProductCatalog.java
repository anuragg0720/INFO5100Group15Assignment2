package model;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products = new ArrayList<>();

    public Product newProduct(String name, int floorPrice, int ceilingPrice, int targetPrice) {
        Product p = new Product(name, floorPrice, ceilingPrice, targetPrice);
        products.add(p);
        return p;
    }

    public List<Product> getProducts() {
        return products;
    }
}
