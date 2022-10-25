package com.example.nectarproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nectarproject.Adapter.CategoriesAdapter;
import com.example.nectarproject.Adapter.ProductAdapter;
import com.example.nectarproject.R;
import com.example.nectarproject.Repo.Remote.ProductModel;
import com.example.nectarproject.ViewModel.ExploreViewModel;
import com.example.nectarproject.ViewModel.ShopViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class CatSearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView searchTitle;
    String currentCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_search);


        //// Get Current Product ////
        Intent ii= getIntent();
        Bundle bun= ii.getExtras();
        if (bun!=null) {
            currentCat = bun.getString("cat");
            searchTitle = findViewById(R.id.search_title);
            searchTitle.setText("Explore " + currentCat);
        }


        //// ViewModel Binding ////
        ExploreViewModel catProductsVM = new ViewModelProvider(this).get(ExploreViewModel.class);
        catProductsVM.getCatProductsList(this, currentCat).observe(this, new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productList) {
                setProducts(productList);
            }
        });


    }

    private void setProducts(List<ProductModel> productList) {
        recyclerView = findViewById(R.id.search_recycler_view);
        ProductAdapter productAdapter = new ProductAdapter(CatSearchActivity.this, productList);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(CatSearchActivity.this, 2));
    }
}