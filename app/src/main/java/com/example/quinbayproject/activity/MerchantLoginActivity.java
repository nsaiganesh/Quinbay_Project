package com.example.quinbayproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quinbayproject.R;

public class MerchantLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_login);
    }
    public void redirectToMerchantRegister(View view)
    {
        Intent intent=new Intent(this,MerchantRegisterActivity.class);
        startActivity(intent);
    }
}