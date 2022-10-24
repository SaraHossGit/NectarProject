package com.example.nectarproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.nectarproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OTPScreen extends AppCompatActivity {

    TextView resendOTP;
    ImageButton backBtn;
    PinView otp;
    String otpValue;
    String otpCheckValue = "5678";
    FloatingActionButton fabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpscreen);

        resendOTP =findViewById(R.id.resend_otp);
        backBtn =findViewById(R.id.otp_back);
        otp =findViewById(R.id.otp_pin_view);
        fabBtn = findViewById(R.id.otp_fab_btn);

        resendOTP.setOnClickListener(view -> finish());
        backBtn.setOnClickListener(view -> finish());

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otpValue = otp.getText().toString();
                if (otpValue.equals(otpCheckValue)){
                    Intent i = new Intent(OTPScreen.this, HomeScreen.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(OTPScreen.this, "OTP Entered is not correct", Toast.LENGTH_SHORT).show();
                    otp.setText("");
                }
            }
        });
    }
}