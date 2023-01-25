package com.example.quinbayproject.api;

import com.example.quinbayproject.model2.MerchantLogin;
import com.example.quinbayproject.model2.MerchantLoginResponse;
import com.example.quinbayproject.model2.MerchantRegister;
import com.example.quinbayproject.model2.ProductItemList;
import com.example.quinbayproject.model2.UserLogin;
import com.example.quinbayproject.model2.UserLoginResponse;
import com.example.quinbayproject.model2.UserRegister;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST(value = "signup")
    Call<Object> addUser(@Body UserRegister userRegister);

    @POST(value = "addMerchant")
    Call<MerchantLoginResponse> addMerchant(@Body MerchantRegister merchantRegister);
    @POST(value ="signIn")
    Call<UserLoginResponse> loginUser(@Body UserLogin userLogin);

    @POST(value = "/merchant/signIn")
    Call<MerchantLoginResponse> loginMerchant(@Body MerchantLogin merchantLogin);
    @GET(value = "getByCategory/{categoryId}")
    Call<ProductItemList> getCategoryProducts(@Path("categoryId") String categoryId);
}
