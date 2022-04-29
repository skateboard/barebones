package me.brennan.barebones.product;

/**
 * @author Brennan / skateboard
 * @since 4/19/2022
 **/
public interface Product {

    String getName();

    double getPrice();

    String getImage();

    int getStock();

    void setStock(int stock);

    String getSku();

    void setSku(String sku);

    void setName(String name);

    void setPrice(double price);

    void setImage(String image);

}
