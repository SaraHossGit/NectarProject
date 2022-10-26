package com.example.nectarproject.UI;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nectarproject.Adapter.ProductAdapter;
import com.example.nectarproject.Adapter.SliderAdapter;
import com.example.nectarproject.R;
import com.example.nectarproject.Repo.Remote.ProductModel;
import com.example.nectarproject.ViewModel.ShopViewModel;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    TextView productName, productBrand, productBrandLink, productPrice,
            productPriceNoDisc, productDescription, productRating, productStock;
    EditText productQuantity;
    ImageButton backBtn, favIcon, incrementBtn, decrementBtn;
    ProductModel currentProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //// Declarations ////
        productName = findViewById(R.id.details_product_name);
        productStock = findViewById(R.id.details_product_stock);
        productBrand = findViewById(R.id.details_product_brand);
        productBrandLink = findViewById(R.id.details_product_brand_link);
        productPrice = findViewById(R.id.details_product_price);
        productPriceNoDisc = findViewById(R.id.details_product_price_nodisc);
        productDescription = findViewById(R.id.details_product_description);
        productRating = findViewById(R.id.details_product_rating);
        productQuantity = findViewById(R.id.details_product_quantity);
        backBtn = findViewById(R.id.details_back_btn);
        favIcon = findViewById(R.id.details_product_fav);
        incrementBtn = findViewById(R.id.details_inc_btn);
        decrementBtn = findViewById(R.id.details_dec_btn);

        //// Back Btn ////
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailsActivity.this.finish();
            }
        });

        //// ViewModel Binding ////
        ShopViewModel productsVM = new ViewModelProvider(this).get(ShopViewModel.class);
        productsVM.getProductsList(this).observe(this, new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productList) {

                //// Get Current Product ////
                Intent ii= getIntent();
                Bundle bun= ii.getExtras();
                if (bun!=null) {
                    int currentProdIdx = bun.getInt("productIdx");
                    currentProd = productList.get(currentProdIdx-1);
                    //// Set Product Data ////
                    setProductData();
                }

                //// Increment Product quantity ////
                ProductModel finalCurrentProd = currentProd;
                incrementBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int q= Integer.parseInt(productQuantity.getText().toString());
                        if (q < finalCurrentProd.getProductStock()){
                            q++;
                        }
                        productQuantity.setText(String.valueOf(q));

                    }
                });

                //// Decrement Product quantity ////
                decrementBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int q= Integer.parseInt(productQuantity.getText().toString());
                        if (q >1){ q--;}
                        productQuantity.setText(String.valueOf(q));

                    }
                });

                //// Toggle favourite button ////
                favIcon.setOnClickListener(new View.OnClickListener() {
                    boolean pressed = false;

                    @Override
                    public void onClick(View view) {
                        pressed=!pressed;
                        if (pressed){
                            favIcon.setImageDrawable(DetailsActivity.this.getDrawable(R.drawable.ic_favorite_enabled));
                        }
                        else {
                            favIcon.setImageDrawable(DetailsActivity.this.getDrawable(R.drawable.ic_favorite));
                        }
                    }
                });


            }
        });

    }

    private void setProductData() {
        productName.setText(currentProd.getProductName());
        productBrand.setText("Brand: " + currentProd.getProductBrand());
        productBrandLink.setText("See similar products from " + currentProd.getProductBrand());
        productDescription.setText(currentProd.getProductDescription());
        productRating.setText(String.valueOf(currentProd.getProductRating()));

        //// Product Price ////
        productPrice.setText("$" + currentProd.getProductPrice());
        double oldPrice = currentProd.getProductPrice() + (currentProd.getProductPrice() * (currentProd.getDiscountPercentage()/100));
        productPriceNoDisc.setText("$" + String.format("%.2f", oldPrice));
        productPriceNoDisc.setPaintFlags(productPriceNoDisc.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG); // Strikethrough Effect

        //// Check Stock ////
        if (currentProd.getProductStock() <= 10){
            productStock.setText(currentProd.getProductStock() + " units left!");
        }

        //// Slider View settings ////
        InitializeSliderView();
    }

    private void InitializeSliderView() {
        SliderView sliderView;
        // initializing the slider view.
        sliderView = findViewById(R.id.details_product_image_slider);
        // passing this array list inside our adapter class.
        SliderAdapter sliderAdapter = new SliderAdapter(getBaseContext(), currentProd.getProductImages());
        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        // below method is used to set adapter to sliderview.
        sliderView.setSliderAdapter(sliderAdapter);
        // below method is use to set scroll time in seconds.
        sliderView.setScrollTimeInSec(3);
        // to set it scrollable automatically
        sliderView.setAutoCycle(true);
        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }


}