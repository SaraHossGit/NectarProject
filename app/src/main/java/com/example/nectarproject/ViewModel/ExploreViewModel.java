package com.example.nectarproject.ViewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nectarproject.Repo.Remote.ProductModel;
import com.example.nectarproject.Repo.Remote.ResponseModel;
import com.example.nectarproject.Retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreViewModel  extends ViewModel {
    private MutableLiveData<List<String>> categoriesList;
    private MutableLiveData<List<ProductModel>> catProductsList;

    public MutableLiveData<List<ProductModel>> getCatProductsList(Context context, String cat) {
        if (catProductsList == null) {
            catProductsList = new MutableLiveData<>();
            loadCatProducts(context, cat);
        }
        return catProductsList;
    }

    public MutableLiveData<List<String>> getCategoriesList(Context context) {
        if (categoriesList == null) {
            categoriesList = new MutableLiveData<>();
            loadCategories(context);
        }
        return categoriesList;
    }

    private void loadCategories(Context context) {
        Call<List<String>> call = RetrofitClient.getInstance().getMyAPI().getCats();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "The code is: " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    return;
                }

                categoriesList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(context, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void loadCatProducts(Context context, String cat) {
        Call<ResponseModel> call = RetrofitClient.getInstance().getMyAPI().searchCategoryProducts(cat);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(context, "The code is: " + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    return;
                }

                ResponseModel responseList = response.body();
                catProductsList.setValue(responseList.getProducts());

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(context, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onFailure: " + t.getMessage());

            }
        });
    }
}
