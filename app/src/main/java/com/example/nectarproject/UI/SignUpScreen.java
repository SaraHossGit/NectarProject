package com.example.nectarproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nectarproject.R;

public class SignUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
    }

    public void goToSignin(View view) {
        Intent i=new Intent(SignUpScreen.this, LoginScreen.class);
        startActivity(i);
    }
}