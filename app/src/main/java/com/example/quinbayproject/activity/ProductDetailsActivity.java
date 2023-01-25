package com.example.quinbayproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quinbayproject.R;
import com.example.quinbayproject.model.ProductsItem;
import com.google.gson.Gson;

public class ProductDetailsActivity extends AppCompatActivity {
ProductsItem productsItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent intent=getIntent();
         productsItem=(ProductsItem)intent.getSerializableExtra("productDetails");
        Log.i("product",productsItem.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageView iv=(ImageView) findViewById(R.id.iv_pd);
        TextView tv1=(TextView) findViewById(R.id.tv_pn);
        TextView tv2=(TextView) findViewById(R.id.tv_price);
        TextView tv3=(TextView) findViewById(R.id.tv_desc);
        TextView tv4=(TextView) findViewById(R.id.tv_category);
        tv1.setText(productsItem.getName());
        tv2.setText(productsItem.getPrice().getPriceDisplay());
        tv3.setText(productsItem.getDesc());
        tv4.setText(productsItem.getAllCategories().get(0));
        Glide.with(iv.getContext()).load(productsItem.getImages().get(0)).into(iv);
    }
    public void addToCart(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Cart",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        int numberOfProducts=sharedPreferences.getInt("numOfProducts",0)+1;
        editor.putInt("numberOfProducts",numberOfProducts);
        Gson gson=new Gson();
        String str=gson.toJson(productsItem);
        editor.putString(String.valueOf(numberOfProducts),str);
        editor.commit();
    }
    public void buyNow(View view)
    {
        //code to buy now
    }
}