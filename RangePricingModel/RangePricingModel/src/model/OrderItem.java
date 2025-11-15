package model;

public class OrderItem {
    private Order order;
    private Product product;
    private int quantity;
    private double actualPrice;

    public OrderItem(Order order, Product product, int quantity, double actualPrice) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.actualPrice = actualPrice;
        updateProductStats();
    }

    private void updateProductStats() {
        double lineRevenue = quantity * actualPrice;
        product.addRevenueBefore(lineRevenue);

        if (actualPrice < product.getTargetPrice()) {
            product.incrementBelowTargetCount();
        } else if (actualPrice > product.getTargetPrice()) {
            product.incrementAboveTargetCount();
        }
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getActualPrice() { return actualPrice; }
}
