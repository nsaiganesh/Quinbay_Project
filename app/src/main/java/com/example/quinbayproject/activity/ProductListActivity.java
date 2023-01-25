package com.example.quinbayproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.quinbayproject.R;
import com.example.quinbayproject.adapter.ProductListAdapter;
import com.example.quinbayproject.api.ApiInterface;
import com.example.quinbayproject.application.CustomApplication;
import com.example.quinbayproject.model.ProductDetails;
import com.example.quinbayproject.model.ProductsItem;
import com.example.quinbayproject.utils.Constants;
import com.example.quinbayproject.adapter.ProductListAdapter;
import com.example.quinbayproject.model.ProductDetails;
import com.example.quinbayproject.model.ProductsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity implements ProductListAdapter.ProductListOnClick {


    private RecyclerView rvProductList;
    private ProductDetails productDetails;
    private List<ProductsItem> productsItem=new ArrayList<>();
    private TextView tvSearchTerm;
    private ImageButton imbtnLayoutChange;
    private ImageButton imbtnBackPress;
    private ImageView ivNoDataFound;
    private ProductListAdapter productListAdapter;
    private ApiInterface apiInterface;
    private String searchTerm;
    private int count = 2;
    private int page=0;
    private ProgressBar progressBar;
    private ProgressBar progressBarItemList;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private boolean isLinearEnabled;
    private  boolean isGridEnabled;
    private CustomApplication customApplication;
    private boolean isStaggeredEnabled;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        tvSearchTerm = findViewById(R.id.tv_searchTerm);
        imbtnLayoutChange = findViewById(R.id.imbtn_layout_change);
        imbtnBackPress = findViewById(R.id.imbtn_back_press);
        progressBar = findViewById(R.id.progress_bar);
        rvProductList = findViewById(R.id.rv_product_list);
        ivNoDataFound = findViewById(R.id.iv_no_data_found);

        searchTerm = getIntent().getStringExtra("searchTerm");

        tvSearchTerm.setText(searchTerm);
        progressBar.setVisibility(View.VISIBLE);

        productListAdapter = new ProductListAdapter(productsItem,ProductListActivity.this,1);
        rvProductList.setAdapter(productListAdapter);
        linearLayoutManager = new LinearLayoutManager(rvProductList.getContext());
        rvProductList.setLayoutManager(linearLayoutManager);
        isLinearEnabled = true;
        customApplication = (CustomApplication) getApplication();
        apiInterface = customApplication.retrofit.create(ApiInterface.class);
//        apiInterface.getProductDetails(searchTerm,false,20,page,0).enqueue(new Callback<ProductDetails>() {
//            @Override
//            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
//
//                if(response.isSuccessful() && response.body()!=null){
//                    progressBar.setVisibility(View.GONE);
//                    page++;
//                    productDetails = response.body();
//                    if(productDetails.getData().getProducts()!=null) {
//
//                        productsItem.addAll(productDetails.getData().getProducts());
//                        productListAdapter.notifyItemRangeInserted(0, productsItem.size());
//                    }
//                    else{
//
//                        ivNoDataFound.setVisibility(View.VISIBLE);
//                        Toast.makeText(ProductListActivity.this,"No details found",Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//                else{
//                        progressBar.setVisibility(View.GONE);
//                        ivNoDataFound.setVisibility(View.VISIBLE);
//                        Toast.makeText(ProductListActivity.this,"No details found",Toast.LENGTH_SHORT).show();
//                        Log.e("Failure in On response", response.code() + "");
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<ProductDetails> call, Throwable t) {
//                ivNoDataFound.setImageDrawable(ContextCompat.getDrawable(ivNoDataFound.getContext(),R.drawable.server_error));
//                ivNoDataFound.setVisibility(View.VISIBLE);
//                Log.e("Failure in On failure",t+"");
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        imbtnLayoutChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count== Constants.LINEAR_LAYOUT){

                    isLinearEnabled = true;
                    isStaggeredEnabled=false;

                    linearLayoutManager = new LinearLayoutManager(rvProductList.getContext());
                    rvProductList.setLayoutManager(linearLayoutManager);
                    productListAdapter.notifyDataSetChanged();

                }
                else if(count==Constants.GRID_LAYOUT){

                    isLinearEnabled = false;
                    isGridEnabled = true;

                    gridLayoutManager = new GridLayoutManager(rvProductList.getContext(),2);
                    rvProductList.setLayoutManager(gridLayoutManager);
                    productListAdapter.notifyDataSetChanged();

                    count =3;
                }
                else{

                    isGridEnabled = false;
                    isStaggeredEnabled = true;

                    staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
                    rvProductList.setLayoutManager(staggeredGridLayoutManager);
                    productListAdapter.notifyDataSetChanged();

                    count=1;
                }
            }
        });

        imbtnBackPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    public void getPosition(int position) {

        Intent intent = new Intent(this,ProductDetailsActivity.class);
        intent.putExtra("productDetails",productsItem.get(position));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    public void loadingDetails(View view){

        progressBarItemList = view.findViewById(R.id.progress_bar_item_list);
        int firstViewCount = -1;
        int totalViews = productsItem.size();
        int totalViewsInScreen = -1;

        if(isLinearEnabled==true) {

            firstViewCount = linearLayoutManager.findFirstVisibleItemPosition();
            totalViewsInScreen = linearLayoutManager.getChildCount();
        }
        else if(isGridEnabled==true){

            totalViewsInScreen = gridLayoutManager.getChildCount();
            firstViewCount = gridLayoutManager.findFirstVisibleItemPosition();
            firstViewCount++;
        }
        else{

            totalViewsInScreen = staggeredGridLayoutManager.getChildCount();
        }
        if((firstViewCount+totalViewsInScreen)==totalViews-1){

            progressBarItemList.setVisibility(View.VISIBLE);

//            apiInterface.getProductDetails(searchTerm,false,20,page,(page*20)+1).enqueue(new Callback<ProductDetails>() {
//                @Override
//                public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
//
//                    if(response.isSuccessful() && response.body()!=null){
//
//                        progressBarItemList.setVisibility(View.GONE);
//                        page++;
//                        int start = productsItem.size()-1;
//                        productDetails = response.body();
//                        if(productDetails.getData().getProducts()!=null) {
//
//                            productsItem.addAll(productDetails.getData().getProducts());
//                            productListAdapter.notifyItemRangeInserted(start,productDetails.getData().getProducts().size());
//                        }
//                        else{
//
//                            Toast.makeText(ProductListActivity.this,"No details found",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    else{
//
//                        progressBarItemList.setVisibility(View.GONE);
//                        if(response.code()==422) {
//
//                            Toast.makeText(ProductListActivity.this, "Reached End/No details Found", Toast.LENGTH_SHORT).show();
//                        }
//                        else {
//
//                            Log.e("Failure in On response", response.code() + "");
//                        }
//
//                    }
//                }
//                @Override
//                public void onFailure(Call<ProductDetails> call, Throwable t) {
//                    progressBarItemList.setVisibility(View.GONE);
//                    Toast.makeText(ProductListActivity.this,"Server Error, Try again",Toast.LENGTH_SHORT).show();
//                    Log.e("Failure in On failure",t+"");
//                }
//            });
        }
    }

    @Override
    public int getTypeOfLayout() {
        if(isLinearEnabled){
            return Constants.LINEAR_LAYOUT;
        }
        else if(isGridEnabled){
            return Constants.GRID_LAYOUT;
        }
        else{
            return Constants.STAGGER_LAYOUT;
        }
    }


}
