package model;

public class Supplier {
    private String name;
    private ProductCatalog productCatalog;

    public Supplier(String StringName) {
        this.name = StringName;
        this.productCatalog = new ProductCatalog();
    }

    public String getName() {
        return name;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    @Override
    public String toString() {
        return name;
    }
}
