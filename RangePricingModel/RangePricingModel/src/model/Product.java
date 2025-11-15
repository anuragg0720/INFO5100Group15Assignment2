package model;

public class Product {
    private String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;

    private int belowTargetCount;
    private int aboveTargetCount;
    private double revenueBefore;
    private double revenueAfter;

    public Product(String name, int floorPrice, int ceilingPrice, int targetPrice) {
        this.name = name;
        this.floorPrice = floorPrice;
        this.ceilingPrice = ceilingPrice;
        this.targetPrice = targetPrice;
    }

    public String getName() { return name; }
    public int getFloorPrice() { return floorPrice; }
    public int getCeilingPrice() { return ceilingPrice; }
    public int getTargetPrice() { return targetPrice; }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public int getBelowTargetCount() { return belowTargetCount; }
    public void incrementBelowTargetCount() { belowTargetCount++; }

    public int getAboveTargetCount() { return aboveTargetCount; }
    public void incrementAboveTargetCount() { aboveTargetCount++; }

    public double getRevenueBefore() { return revenueBefore; }
    public void addRevenueBefore(double value) { this.revenueBefore += value; }

    public double getRevenueAfter() { return revenueAfter; }
    public void setRevenueAfter(double revenueAfter) { this.revenueAfter = revenueAfter; }

    @Override
    public String toString() {
        return name;
    }
}
