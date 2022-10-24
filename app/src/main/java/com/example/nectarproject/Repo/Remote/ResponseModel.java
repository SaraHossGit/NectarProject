package com.example.nectarproject.Repo.Remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("products")
    private List<ProductModel> products = null;
    @SerializedName("total")
    private int total;

    public List<ProductModel> getProducts() {
        return products;
    }
}

