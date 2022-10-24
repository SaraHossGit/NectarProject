package com.example.nectarproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.nectarproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hbb20.CountryCodePicker;

public class MobileNumScreen extends AppCompatActivity {

    String countryCode = "91";
    CountryCodePicker countryCodePicker;
    FloatingActionButton fabBtn;
    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_num);

        countryCodePicker = findViewById(R.id.country_code_picker);
        fabBtn = findViewById(R.id.mobile_num_fab_btn);
        backBtn =findViewById(R.id.mobile_num_back);

        backBtn.setOnClickListener(view -> finish());

        countryCodePicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                countryCode = countryCodePicker.getSelectedCountryCode();
                Log.d("Country Code", countryCode);
            }
        });

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MobileNumScreen.this, OTPScreen.class);
                startActivity(i);
            }
        });
    }
}