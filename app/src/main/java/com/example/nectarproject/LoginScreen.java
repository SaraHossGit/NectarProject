package com.example.nectarproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class LoginScreen extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        handler.postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                Intent i=new Intent(LoginScreen.this, SignUpScreen.class);
//                startActivity(i);
//            }
//        }, 4000);
//    }

    public void goToSignup(View view) {
        Intent i=new Intent(LoginScreen.this, SignUpScreen.class);
        startActivity(i);
    }
}