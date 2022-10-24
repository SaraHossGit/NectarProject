package com.example.nectarproject.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.nectarproject.Repo.Remote.ProductModel;
import com.example.nectarproject.Repo.Remote.ResponseModel;
import com.example.nectarproject.Retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsViewModel extends ViewModel {
    private MutableLiveData<List<ProductModel>> productsList;

    public MutableLiveData<List<ProductModel>> getProductsList(Context context) {
        if (productsList == null) {
            productsList = new MutableLiveData<>();
            loadProducts(context);
        }
        return productsList;
    }

    private void loadProducts(Context context) {
        Call<ResponseModel> call = RetrofitClient.getInstance().getMyAPI().getProducts();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "The code is: " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    return;
                }

                ResponseModel responseList = response.body();
                productsList.setValue(responseList.getProducts());
//                Product title = new Product();
//                title.type = Product.TITLE_TYPE;
//                products.add(0, title);
//
//                ProductsAdapter productsAdapter = new ProductsAdapter(MainActivity.this, products);
//                recyclerView.setAdapter(productsAdapter);
//                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(context, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onFailure: " + t.getMessage());

            }
        });
    }
}
