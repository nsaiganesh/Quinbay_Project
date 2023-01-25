package com.example.quinbayproject.activity;

import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.quinbayproject.R;
import com.example.quinbayproject.application.CustomApplication;
import com.example.quinbayproject.model.ProductsItem;
import com.example.quinbayproject.model.ProductsItem;
import com.google.gson.Gson;

public class ProductDetailsActivity extends AppCompatActivity {

    ProductsItem productsItem;
    ImageView ivProduct;
    TextView tvProductName;
    TextView tvProductPrice;
    TextView tvProductStrikePrice;
    TextView tvProductBrand;
    TextView tvProductCategory;
    Button btnAddToWishList;
    CustomApplication customApplication;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        ivProduct = findViewById(R.id.iv_product);
        tvProductName = findViewById(R.id.tv_product_name);
        tvProductPrice = findViewById(R.id.tv_product_price);
        tvProductStrikePrice=findViewById(R.id.tv_product_strike_price);
        tvProductBrand = findViewById(R.id.tv_product_brand);
        tvProductCategory = findViewById(R.id.tv_product_category);
        btnAddToWishList = findViewById(R.id.btn_add_to_wishlist);
        productsItem = (ProductsItem) getIntent().getSerializableExtra("productDetails");

        Glide.with(ivProduct.getContext()).load(productsItem.getImages().get(0)).into(ivProduct);
        tvProductName.setText(productsItem.getName());
        tvProductPrice.setText(productsItem.getPrice().getPriceDisplay());
        if(productsItem.getPrice().getStrikeThroughPriceDisplay()!=null) {

            tvProductStrikePrice.setText(productsItem.getPrice().getStrikeThroughPriceDisplay());
            tvProductStrikePrice.setPaintFlags(tvProductStrikePrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }
        else{
            tvProductStrikePrice.setVisibility(View.GONE);
        }
        tvProductBrand.setText(productsItem.getBrand());
        tvProductCategory.setText(productsItem.getAllCategories().get(0));

        customApplication = (CustomApplication) getApplication();
        int count = customApplication.sharedPreferences.getInt(String.valueOf(productsItem.getId()),-1);
        if(count!=-1){
            btnAddToWishList.setVisibility(View.GONE);
        }
        else{
            btnAddToWishList.setText("Add To WishList");
            btnAddToWishList.setEnabled(true);
            btnAddToWishList.setVisibility(View.VISIBLE);
        }

        btnAddToWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAddToWishList.setText("Added");
                btnAddToWishList.setEnabled(false);
                Gson gson = new Gson();
                String json = gson.toJson(productsItem);
                int noOfProducts = customApplication.sharedPreferences.getInt("noOfProducts",-1);
                SharedPreferences.Editor editor= customApplication.sharedPreferences.edit();
                editor.putString(String.valueOf(noOfProducts+1),json);
                editor.putInt("noOfProducts",noOfProducts+1);
                editor.putInt(String.valueOf(productsItem.getId()),1);
                editor.commit();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
