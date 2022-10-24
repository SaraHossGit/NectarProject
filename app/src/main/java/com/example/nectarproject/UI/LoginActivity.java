package com.example.nectarproject.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nectarproject.R;

public class LoginActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        Intent i=new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(i);
    }
}