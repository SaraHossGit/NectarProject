package com.example.nectarproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;
    ProductAdapter productAdapter1, productAdapter2, productAdapter3;
    GroceriesAdapter groceriesAdapter;
    ArrayList <ProductModel> productList = new ArrayList<>();
    ArrayList <GroceriesModel> groceryList = new ArrayList<>();

    // Product Data
    int[] productImage = {R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4};
    String[] productName = {"Organic Bananas", "Bell Pepper", "Ginger", "Meat"};
    String[] productAmount = {"7pcs, Priceg", "7pcs, Priceg", "7pcs, Priceg", "7pcs, Priceg"};
    String[] productPrice = {"$4.99", "$4.99", "$4.99", "$4.99"};

    // Groceries Data
    int[] groceryImage = {R.drawable.pulses, R.drawable.rice};
    int[] cardViewColor = {Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175")};
    String[] groceryName = {"Pulses", "Rice"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView1 = findViewById(R.id.exclusive_recycler_view);
        productAdapter1 = new ProductAdapter(this, productList);
        recyclerView1.setAdapter(productAdapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerView2 = findViewById(R.id.best_selling_recycler_view);
        productAdapter2 = new ProductAdapter(this, productList);
        recyclerView2.setAdapter(productAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerView3 = findViewById(R.id.last_recycler_view);
        productAdapter3 = new ProductAdapter(this, productList);
        recyclerView3.setAdapter(productAdapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        setProducts();

        recyclerView4 = findViewById(R.id.groceries_recycler_view);
        groceriesAdapter = new GroceriesAdapter(this, groceryList);
        recyclerView4.setAdapter(groceriesAdapter);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

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

    private void setProducts() {
        for (int i = 0; i < productName.length;i++){
            productList.add(new ProductModel(
                    productImage[i],
                    productName[i],
                    productAmount[i],
                    productPrice[i]
            ));
        }
    }
}