package com.example.quinbayproject.activity;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quinbayproject.R;
import com.example.quinbayproject.adapter.CategoryListAdapter;
import com.example.quinbayproject.api.ApiInterface;
import com.example.quinbayproject.application.CustomApplication;
import com.example.quinbayproject.model2.ProductItemList;
import com.example.quinbayproject.model2.ProductsDtoListItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryListActivity extends AppCompatActivity implements CategoryListAdapter.ProductListOnClick {
    private RecyclerView rvProductList;
    private ProductItemList productItemList;

    private List<ProductsDtoListItem> productsDtoListItems = new ArrayList<ProductsDtoListItem>();
    private ImageView ivNoDataFound;
    private CategoryListAdapter categoryListAdapter;
    private ApiInterface apiInterface;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;
    private CustomApplication customApplication;
    private TextView tvSearchTerm;
    private ImageButton imbtnBackPress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        tvSearchTerm = findViewById(R.id.tv_searchTerm);
        imbtnBackPress = findViewById(R.id.imbtn_back_press);
        progressBar = findViewById(R.id.progress_bar);
        rvProductList = findViewById(R.id.rv_category_product_list);
        ivNoDataFound = findViewById(R.id.iv_no_data_found);

        progressBar.setVisibility(View.VISIBLE);

        categoryListAdapter = new CategoryListAdapter(productsDtoListItems,CategoryListActivity.this);
        rvProductList.setAdapter(categoryListAdapter);
        linearLayoutManager = new LinearLayoutManager(rvProductList.getContext());
        rvProductList.setLayoutManager(linearLayoutManager);
        customApplication = (CustomApplication) getApplication();
        apiInterface = customApplication.retrofit.create(ApiInterface.class);
        String categoryId = getIntent().getStringExtra("categoryId");
        getProductApi(categoryId);

    }

    @Override
    public void getPosition(int position) {

    }

    public void getProductApi(String categoryId){

        apiInterface.getCategoryProducts(categoryId).enqueue(new Callback<ProductItemList>() {
            @Override
            public void onResponse(Call<ProductItemList> call, Response<ProductItemList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    progressBar.setVisibility(View.GONE);
                    productItemList = response.body();
                    if (productItemList != null) {
                        productsDtoListItems.addAll(productItemList.getProductsDtoList());
                        Log.e("Success",productsDtoListItems+"");
                        categoryListAdapter.notifyItemRangeInserted(0, productsDtoListItems.size());
                    } else {

                        ivNoDataFound.setVisibility(View.VISIBLE);
                        Toast.makeText(CategoryListActivity.this, "No details found", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    progressBar.setVisibility(View.GONE);
                    ivNoDataFound.setVisibility(View.VISIBLE);
                    Toast.makeText(CategoryListActivity.this, "No details found", Toast.LENGTH_SHORT).show();
                    Log.e("Failure in On response", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<ProductItemList> call, Throwable t) {
               progressBar.setVisibility(View.GONE);
               Log.e("Error",""+t);
               Toast.makeText(CategoryListActivity.this,""+t,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
