package com.example.nectarproject;

public class ProductModel {
    private int productImage;
    private String productName;
    private String productAmount;
    private String productPrice;

    public ProductModel(int productImage, String productName, String productAmount, String productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
