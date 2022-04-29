package me.brennan.barebones.product;

/**
 * @author Brennan / skateboard
 * @since 4/19/2022
 **/
public abstract class AbstractProduct implements Product{
    private String name, sku, image;
    private double price;
    private int stock;

    public AbstractProduct(String name, String sku, String image, double price, int stock) {
        this.name = name;
        this.sku = sku;
        this.image = image;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setImage(String image) {
        this.image = image;
    }
}
