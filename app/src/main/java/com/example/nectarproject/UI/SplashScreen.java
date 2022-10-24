package com.example.nectarproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.nectarproject.R;

public class SplashScreen extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }


    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this, GetStartedScreen.class);
                startActivity(i);
            }
        }, 4000);
    }
}

