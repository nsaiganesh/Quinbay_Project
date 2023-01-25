package com.example.quinbayproject.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.quinbayproject.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomApplication extends Application {

    public SharedPreferences sharedPreferences;

    public Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = getSharedPreferences("QuinbayEcommerce", Context.MODE_PRIVATE);
        retrofit = getRetrofit();
    }

    private Retrofit getRetrofit() {
        if(retrofit==null){
            synchronized (this){
                if(retrofit==null){
                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();
                    retrofit = new Retrofit.Builder()
                            .client(new OkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .baseUrl(Constants.BASE_URL)
                            .build();
                }
            }
        }

        return retrofit;
    }
}
