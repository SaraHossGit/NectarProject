package com.example.nectarproject.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nectarproject.R;

public class SplashActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }


    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i=new Intent(SplashActivity.this, GetStartedActivity.class);
                startActivity(i);
            }
        }, 4000);
    }
}

