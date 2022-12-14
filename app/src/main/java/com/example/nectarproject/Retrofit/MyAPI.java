package com.example.nectarproject.Retrofit;

import com.example.nectarproject.Repo.Remote.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyAPI {
    static String BASE_URL= "https://dummyjson.com/";

    @GET ("products")
    Call<ResponseModel> getProducts();

    @GET ("products/search?")
    Call<ResponseModel> searchProducts(@Query("q") CharSequence query);

    @GET ("products/category/{cat}")
    Call<ResponseModel> searchCategoryProducts(@Path("cat") CharSequence cat);

    @GET ("products/categories")
    Call<List<String>> getCats();

}
