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
import com.example.quinbayproject.model2.UserRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRegisterActivity extends AppCompatActivity {

    private EditText etUserRegisterUserFirstName;
    private EditText etUserRegisterUserLastName;
    private EditText etUserRegisterUserEmail;
    private EditText etUserRegisterUserPassword;
    private EditText etUserRegisterPhoneNumber;
    private EditText etUserRegisterCity;
    private EditText etUserRegisterState;
    private Button btnUserRegister;
    private UserRegister userRegister;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        etUserRegisterUserFirstName = findViewById(R.id.et_register_user_first_name);
        etUserRegisterUserLastName = findViewById(R.id.et_register_user_last_name);
        etUserRegisterUserFirstName = findViewById(R.id.et_register_user_first_name);
        etUserRegisterUserEmail = findViewById(R.id.et_register_user_email);
        etUserRegisterUserPassword = findViewById(R.id.et_register_user_password);
        etUserRegisterPhoneNumber = findViewById(R.id.et_register_user_phone_number);
        etUserRegisterCity = findViewById(R.id.et_register_user_city);
        etUserRegisterState = findViewById(R.id.et_register_user_state);
        btnUserRegister = findViewById(R.id.btn_user_register);
        btnUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerUser();
            }
        });
    }

    public void registerUser(){

        userRegister = new UserRegister();
        String userFirstName = etUserRegisterUserFirstName.getText().toString().trim();
        String userLastName = etUserRegisterUserLastName.getText().toString().trim();
        String userEmail = etUserRegisterUserEmail.getText().toString().trim();
        String userPassword = etUserRegisterUserPassword.getText().toString().trim();
        String userPhoneNumber = etUserRegisterPhoneNumber.getText().toString().trim();
        String userCity = etUserRegisterCity.getText().toString().trim();
        String userState = etUserRegisterState.getText().toString().trim();
        if(!userFirstName.isEmpty() && !userLastName.isEmpty() && !userEmail.isEmpty() && !userPassword.isEmpty() && !userCity.isEmpty() && !userState.isEmpty() && !userPhoneNumber.isEmpty()) {

            userRegister.setFirstName(userFirstName);
            userRegister.setLastName(userLastName);
            userRegister.setEmail(userEmail);
            userRegister.setPassword(userPassword);
            userRegister.setPhoneNumber(userPhoneNumber);
            userRegister.setCity(userCity);
            userRegister.setState(userState);

            apiCallToRegister(userRegister);
        }
        else {

            Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show();
        }
    }

    private void apiCallToRegister(UserRegister userRegister) {

        apiInterface = ((CustomApplication)getApplication()).retrofit.create(ApiInterface.class);
        apiInterface.addUser(userRegister).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(UserRegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserRegisterActivity.this,UserLoginActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(UserRegisterActivity.this,"SomeThing Went Wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(UserRegisterActivity.this,"SomeThing Went Wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

