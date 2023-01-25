package com.example.quinbayproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quinbayproject.R;
import com.example.quinbayproject.api.ApiInterface;
import com.example.quinbayproject.application.CustomApplication;
import com.example.quinbayproject.model2.MerchantLoginResponse;
import com.example.quinbayproject.model2.MerchantRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MerchantRegisterActivity extends AppCompatActivity {
    private EditText etMerchantRegisterMerchantFirstName;
    private EditText etMerchantRegisterMerchantLastName;
    private EditText etMerchantRegisterMerchantEmail;
    private EditText etMerchantRegisterMerchantPassword;
    private EditText etMerchantRegisterPhoneNumber;
    private EditText etMerchantRegisterCity;
    private EditText etMerchantRegisterState;
    private EditText etMerchantRegisterCompanyName;
    private Button btnMerchantRegister;
    private MerchantRegister merchantRegister;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_register);
        etMerchantRegisterMerchantFirstName = findViewById(R.id.et_register_merchant_first_name);
        etMerchantRegisterMerchantLastName = findViewById(R.id.et_register_merchant_last_name);
        etMerchantRegisterMerchantFirstName = findViewById(R.id.et_register_merchant_first_name);
        etMerchantRegisterMerchantEmail = findViewById(R.id.et_register_merchant_email);
        etMerchantRegisterMerchantPassword = findViewById(R.id.et_register_merchant_password);
        etMerchantRegisterPhoneNumber = findViewById(R.id.et_register_merchant_phone_number);
        etMerchantRegisterCity = findViewById(R.id.et_register_merchant_city);
        etMerchantRegisterState = findViewById(R.id.et_register_merchant_state);
        etMerchantRegisterCompanyName = findViewById(R.id.et_register_merchant_company_name);
        btnMerchantRegister = findViewById(R.id.btn_merchant_register);
        btnMerchantRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerMerchant();
            }
        });
    }

    public void registerMerchant(){
        merchantRegister = new MerchantRegister();
        String merchantFirstName = etMerchantRegisterMerchantFirstName.getText().toString().trim();
        String merchantLastName = etMerchantRegisterMerchantLastName.getText().toString().trim();
        String merchantEmail = etMerchantRegisterMerchantEmail.getText().toString().trim();
        String merchantPassword = etMerchantRegisterMerchantPassword.getText().toString().trim();
        String merchantPhoneNumber = etMerchantRegisterPhoneNumber.getText().toString().trim();
        String merchantCity = etMerchantRegisterCity.getText().toString().trim();
        String merchantState = etMerchantRegisterState.getText().toString().trim();
        String merchantCompanyName = etMerchantRegisterCompanyName.getText().toString().trim();
        if(!merchantFirstName.isEmpty() && !merchantLastName.isEmpty() && !merchantEmail.isEmpty() && !merchantPassword.isEmpty() && !merchantCity.isEmpty() && !merchantState.isEmpty() && !merchantPhoneNumber.isEmpty() && !merchantCompanyName.isEmpty()) {

            merchantRegister.setMerchantName(merchantFirstName);
//            merchantRegister.setLastName(merchantLastName);
            merchantRegister.setMerchantId(merchantEmail);
            merchantRegister.setMerchantPassword(merchantPassword);
            merchantRegister.setMerchantPhone(merchantPhoneNumber);
            merchantRegister.setMerchantCity(merchantCity);
            merchantRegister.setMerchantState(merchantState);
            merchantRegister.setCompany(merchantCompanyName);

            apiCallToRegister(merchantRegister);
        }
        else {
            Toast.makeText(this, "All Fields Required", Toast.LENGTH_SHORT).show();
        }


    }

    private void apiCallToRegister(MerchantRegister merchantRegister) {
        apiInterface = ((CustomApplication)getApplication()).retrofit.create(ApiInterface.class);
        apiInterface.addMerchant(merchantRegister).enqueue(new Callback<MerchantLoginResponse>() {
            @Override
            public void onResponse(Call<MerchantLoginResponse> call, Response<MerchantLoginResponse> response) {
                if(response.isSuccessful()) {
                    Log.e("Success",response.body()+"");
                    Toast.makeText(MerchantRegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MerchantRegisterActivity.this,MerchantLoginActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MerchantRegisterActivity.this,"SomeThing Went Wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MerchantLoginResponse> call, Throwable t) {
                Toast.makeText(MerchantRegisterActivity.this,"SomeThing Went Wrong",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
