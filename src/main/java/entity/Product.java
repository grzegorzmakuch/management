package entity;

public class Product {

    public final static String PRODUCT_SEPARATOR = "#";

    private Long id;
    private String productName;
    protected Float price;
    private Float weight;
    private String color;
    protected Integer productCount;

    public Product(Long id, String productName, Float price, Float weight, String color, Integer productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPARATOR + productName + PRODUCT_SEPARATOR + price + PRODUCT_SEPARATOR + weight + PRODUCT_SEPARATOR + color + PRODUCT_SEPARATOR + productCount;
    }
}
