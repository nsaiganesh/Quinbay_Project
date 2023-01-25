package com.example.quinbayproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.quinbayproject.R;
import com.example.quinbayproject.adapter.ViewPageAdapter;
import com.example.quinbayproject.adapter.ViewPageAdapter;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUserLogin;
    private TextView tvMerchantLogin;
    private EditText etSearchTerm;
    private String searchTerm;
    ViewPager mViewPager;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;

    // images array

    // Creating Object of ViewPagerAdapter
    ViewPageAdapter mViewPagerAdapter;
    String[] images = {"https://m.media-amazon.com/images/I/71hCsrR3XiL._SL1500_.jpg","https://www.lenovo.com/medias/?context=bWFzdGVyfHJvb3R8MzMyNzI2fGltYWdlL3BuZ3xoNmMvaDc4LzE0NzMwMTY2ODI5MDg2LnBuZ3w3MDI3ZGVjODY4M2NkZjRiZjViYTY2OTdlNzM4ZTA0MDUzZjVhMjU3NmRkMjM0NTQ3ODAyNDVmMDcyNjFiMmFi","https://wogom-cdn-data.mo.cloudinary.net/img/Product/Main/LGHome-EntertainmentTelevision-19_10_2022_17_36_15_339.jpg?tx=f_auto,c_scale,w_400","https://cdn1.ethoswatches.com/media/catalog/product/cache/6e5de5bc3d185d8179cdc7258143f41a/s/e/seiko-astron-sse007j1-large.jpg","https://m.media-amazon.com/images/I/41TyYW9uMKL._AC_SS450_.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUserLogin = findViewById(R.id.tv_login);
        tvMerchantLogin = findViewById(R.id.tv_merchant);
        etSearchTerm = findViewById(R.id.et_search_term);
        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        imageView3 = findViewById(R.id.img3);
        imageView4 = findViewById(R.id.img4);
        imageView5 = findViewById(R.id.img5);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callProductListactivity("5");
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 callProductListactivity("1");
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 callProductListactivity("3");
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 callProductListactivity("4");
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callProductListactivity("2");
            }
        });
        etSearchTerm.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    searchTerm = etSearchTerm.getText().toString().trim();
                    if(!searchTerm.isEmpty()) {
                        Intent intent = new Intent(HomeActivity.this, ProductListActivity.class);
                        intent.putExtra("searchTerm",searchTerm);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(HomeActivity.this,"Enter the text in Search Field",Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });


        tvUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,UserLoginActivity.class);
                startActivity(intent);

            }
        });

        tvMerchantLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(HomeActivity.this, MerchantLoginActivity.class);
                    startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPageAdapter(HomeActivity.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    public void callProductListactivity(String categoryId){

        Intent intent = new Intent(HomeActivity.this,CategoryListActivity.class);
        intent.putExtra("categoryId",categoryId);
        startActivity(intent);
    }
}