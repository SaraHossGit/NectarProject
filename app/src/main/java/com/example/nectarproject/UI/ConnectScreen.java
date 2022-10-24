package com.example.nectarproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nectarproject.R;

public class ConnectScreen extends AppCompatActivity {

    Button phoneConnectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        phoneConnectBtn = findViewById(R.id.phone_connect);
        phoneConnectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConnectScreen.this, MobileNumScreen.class);
                startActivity(i);
            }
        });
    }
}