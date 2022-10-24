package com.example.nectarproject.UI;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nectarproject.Adapter.GroceriesAdapter;
import com.example.nectarproject.Adapter.ProductAdapter;
import com.example.nectarproject.R;
import com.example.nectarproject.Repo.Local.GroceriesModel;
import com.example.nectarproject.Repo.Remote.ProductModel;
import com.example.nectarproject.ViewModel.ShopViewModel;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    private ShopViewModel mViewModel;
    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;
    ProductAdapter productAdapter1, productAdapter2, productAdapter3;
    GroceriesAdapter groceriesAdapter;
    ArrayList<ProductModel> productList1 = new ArrayList<>();
    ArrayList <ProductModel> productList2 = new ArrayList<>();
    ArrayList <ProductModel> productList3 = new ArrayList<>();
    ArrayList <GroceriesModel> groceryList = new ArrayList<>();

//    // Exclusive Product Data
//    int[] productImage1 = {R.drawable.item6, R.drawable.item7, R.drawable.item1, R.drawable.item2, R.drawable.item3};
//    String[] productName1 = {"Tomatoes", "Carrots", "Organic Bananas", "Bell Pepper", "Ginger"};
//    String[] productAmount1 = {"1Kg", "2Kg", "7pcs, Priceg", "7pcs, Priceg", "7pcs, Priceg"};
//    String[] productPrice1 = {"$10.99", "$6.99", "$4.99", "$5.50", "$4.99"};
//
//    // Best Selling Product Data
//    int[] productImage2 = {R.drawable.item4, R.drawable.item5};
//    String[] productName2 = {"Meat", "Chicken"};
//    String[] productAmount2 = {"1Kg, Priceg", "1Kg, Priceg"};
//    String[] productPrice2 = {"$40.00", "$35.99"};
//
//    // Last Product Data
//    int[] productImage3 = {R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4};
//    String[] productName3 = {"Organic Bananas", "Bell Pepper", "Ginger", "Meat"};
//    String[] productAmount3 = {"7pcs, Priceg", "7pcs, Priceg", "7pcs, Priceg", "7pcs, Priceg"};
//    String[] productPrice3 = {"$4.99", "$4.99", "$4.99", "$4.99"};

    // Groceries Data
    int[] groceryImage = {R.drawable.pulses, R.drawable.rice};
    int[] cardViewColor = {Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175")};
    String[] groceryName = {"Pulses", "Rice"};

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

        //
//        recyclerView1 = findViewById(R.id.exclusive_recycler_view);
//        productAdapter1 = new ProductAdapter(this, productList1);
//        recyclerView1.setAdapter(productAdapter1);
//        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        setProducts(1);
//
//        recyclerView2 = findViewById(R.id.best_selling_recycler_view);
//        productAdapter2 = new ProductAdapter(this, productList2);
//        recyclerView2.setAdapter(productAdapter2);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        setProducts(2);
//

//
//        setProducts(3);

        ShopViewModel productsVM = new ViewModelProvider(this).get(ShopViewModel.class);
        productsVM.getProductsList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productList) {
                recyclerView3 = getView().findViewById(R.id.last_recycler_view);
                productAdapter3 = new ProductAdapter(getContext(), productList);
                recyclerView3.setAdapter(productAdapter3);
                recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            }
        });
        recyclerView4 = getView().findViewById(R.id.groceries_recycler_view);
        groceriesAdapter = new GroceriesAdapter(getContext(), groceryList);
        recyclerView4.setAdapter(groceriesAdapter);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        setGroceries();

    }




    private void setGroceries() {
        for (int i = 0; i < groceryName.length;i++){
            groceryList.add(new GroceriesModel(
                    cardViewColor[i],
                    groceryImage[i],
                    groceryName[i]
            ));
        }
    }

//    private void setProducts(int listNum) {
//            switch (listNum){
//                case 1:
//                    for (int i = 0; i < productName1.length;i++) {
//                        productList1.add(new ProductModel(
//                                productImage1[i],
//                                productName1[i],
//                                productAmount1[i],
//                                productPrice1[i]
//                        ));
//                    }
//                    break;
//                case 2:
//                    for (int i = 0; i < productName2.length;i++) {
//                        productList2.add(new ProductModel(
//                                productImage2[i],
//                                productName2[i],
//                                productAmount2[i],
//                                productPrice2[i]
//                        ));
//                    }
//                    break;
//                case 3:
//                    for (int i = 0; i < productName3.length;i++) {
//                        productList3.add(new ProductModel(
//                                productImage3[i],
//                                productName3[i],
//                                productAmount3[i],
//                                productPrice3[i]
//                        ));
//                    }
//                    break;
//            }
//
//
//    }

}