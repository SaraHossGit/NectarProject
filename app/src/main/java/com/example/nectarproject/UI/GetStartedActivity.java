package com.example.nectarproject.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nectarproject.R;

public class GetStartedActivity extends AppCompatActivity {

    Button getStartedBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        getStartedBtn = findViewById(R.id.get_started_btn);
        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(GetStartedActivity.this, ConnectActivity.class);
                startActivity(i);
            }
        });
    }
}