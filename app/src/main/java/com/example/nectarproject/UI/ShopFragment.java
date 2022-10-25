package com.example.nectarproject.UI;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nectarproject.Adapter.CategoriesAdapter;
import com.example.nectarproject.Adapter.ProductAdapter;
import com.example.nectarproject.R;
import com.example.nectarproject.Repo.Local.CategoriesModel;
import com.example.nectarproject.Repo.Remote.ProductModel;
import com.example.nectarproject.ViewModel.ShopViewModel;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    private ShopViewModel mViewModel;
    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;
    ProductAdapter productAdapter1, productAdapter2, productAdapter3;
    RecyclerView recyclerView;
    CategoriesAdapter categoriesAdapter;

    ArrayList <CategoriesModel> categoriesModelsList = new ArrayList<>();
    // Groceries Data
    int[] catImage = {R.drawable.smartphones, R.drawable.laptops, R.drawable.fragrances,
            R.drawable.skincare, R.drawable.groceries, R.drawable.home_decoration, R.drawable.furniture,
            R.drawable.tops, R.drawable.womens_dresses, R.drawable.womens_shoes, R.drawable.mens_shirts,
            R.drawable.mens_shoes, R.drawable.mens_watches, R.drawable.womens_watches, R.drawable.womens_bags,
            R.drawable.womens_jewellery, R.drawable.sunglasses, R.drawable.automotive, R.drawable.motorcycle,
            R.drawable.lighting
    };

    int[] cardViewColor = {Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40B7DFF5"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40B7DFF5"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40FDE598"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40B7DFF5"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40FDE598")};

    public static ShopFragment newInstance() {
        return new ShopFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        // TODO: Use the ViewModel

        ShopViewModel productsVM = new ViewModelProvider(this).get(ShopViewModel.class);

        // Get Products
        productsVM.getProductsList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productList) {
                setProducts(productList);
            }
        });

        // Get Categories
        productsVM.getCategoriesList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> catList) {
                setCategories(catList);
            }
        });

    }

    private void setProducts(List<ProductModel> productList) {
        // When all products are fetched categorize them into:

        // 1. Exclusive offer (discount>15)
        ArrayList<ProductModel> exclusiveOffers  = new ArrayList<>();
        for ( ProductModel product : productList){
            if (product.getDiscountPercentage() >=15){
                exclusiveOffers.add(product);
            }
        }
        recyclerView1 = getView().findViewById(R.id.exclusive_recycler_view);
        productAdapter1 = new ProductAdapter(getContext(), exclusiveOffers);
        recyclerView1.setAdapter(productAdapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // 2. Best selling (quantity<20)
        ArrayList<ProductModel> bestSelling  = new ArrayList<>();
        for ( ProductModel product : productList){
            if (product.getProductStock() <=20){
                bestSelling.add(product);
            }
        }
        recyclerView2 = getView().findViewById(R.id.best_selling_recycler_view);
        productAdapter2 = new ProductAdapter(getContext(), bestSelling);
        recyclerView2.setAdapter(productAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        // 3. Highly recommended (rating>4.5)
        ArrayList<ProductModel> highlyRecom  = new ArrayList<>();
        for ( ProductModel product : productList){
            if (product.getProductRating() >=4.5){
                highlyRecom.add(product);
            }
        }
        recyclerView3 = getView().findViewById(R.id.last_recycler_view);
        productAdapter3 = new ProductAdapter(getContext(), highlyRecom);
        recyclerView3.setAdapter(productAdapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }


    private void setCategories(List<String> catList) {

        for (int i = 0; i < catList.size();i++){
            categoriesModelsList.add(new CategoriesModel(
                    CategoriesModel.MIN_VIEW,
                    cardViewColor[i],
                    catImage[i],
                    catList.get(i)
            ));
        }
        recyclerView = getView().findViewById(R.id.groceries_recycler_view);
        categoriesAdapter = new CategoriesAdapter(getContext(), categoriesModelsList);
        recyclerView.setAdapter(categoriesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

    }

}