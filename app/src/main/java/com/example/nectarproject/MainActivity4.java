package com.example.nectarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity4 extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i=new Intent(MainActivity4.this, SignUpScreen.class);
                startActivity(i);
            }
        }, 4000);
    }
}