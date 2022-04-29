package me.brennan.barebones.product.provided;

import me.brennan.barebones.product.AbstractProduct;

/**
 * @author Brennan / skateboard
 * @since 4/19/2022
 **/
public class SimpleProduct extends AbstractProduct {

    public SimpleProduct(String name, String sku, String image, double price, int stock) {
        super(name, sku, image, price, stock);
    }
}
