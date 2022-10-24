package com.example.nectarproject.Repo.Remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductModel {
    @SerializedName("title")
    private String productName;
    @SerializedName("description")
    private String productDescription;
    @SerializedName("price")
    private double productPrice;
    @SerializedName("rating")
    private double productRating;
    @SerializedName("stock")
    private int productStock;
    @SerializedName("brand")
    private String productBrand;
    @SerializedName("category")
    private String productCategory;
    @SerializedName("thumbnail")
    private String productImage;
    @SerializedName("images")
    private List<String> ProductImages = null;

    public List<String> getProductImages() {
        return ProductImages;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getProductRating() {
        return productRating;
    }

    public int getProductStock() {
        return productStock;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductCategory() {
        return productCategory;
    }
}
