package com.example.quinbayproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quinbayproject.R;

public class MerchantRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_register);
    }
    public void redirectToLogin(View view)
    {
        Intent intent=new Intent(this,MerchantLoginActivity.class);
        startActivity(intent);
    }

}