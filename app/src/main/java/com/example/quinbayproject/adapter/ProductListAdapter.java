package com.example.quinbayproject.adapter;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quinbayproject.R;
import com.example.quinbayproject.model.ProductsItem;
import com.example.quinbayproject.utils.Constants;
import com.example.quinbayproject.model.ProductsItem;
import com.example.quinbayproject.utils.Constants;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ProductsItem> productsItem;
    ProductListOnClick productListOnClick;
    int typeOfClass;
    public ProductListAdapter(List<ProductsItem> productItem, ProductListOnClick productListOnClick, int typeOfClass){

        this.productsItem = productItem;
        this.productListOnClick = productListOnClick;
        this.typeOfClass = typeOfClass;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType==Constants.LINEAR_LAYOUT || typeOfClass==2) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_details_linear, parent, false);
            return new ProductListViewHolderLinear(view);
        }
        else{

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_details_grid, parent, false);
            return new ProductListViewHolderGrid(view);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
          if(getItemViewType(position)==Constants.LINEAR_LAYOUT) {
              ((ProductListViewHolderLinear) holder).bind(productsItem.get(position));
          }
          else{
              ((ProductListViewHolderGrid) holder).bind(productsItem.get(position));
          }
    }

    @Override
    public int getItemCount() {

            return productsItem.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(productListOnClick.getTypeOfLayout()== Constants.LINEAR_LAYOUT){

            return Constants.LINEAR_LAYOUT;
        }
        else{

            return  Constants.GRID_LAYOUT;
        }
    }

    public class ProductListViewHolderLinear extends RecyclerView.ViewHolder{

        TextView tvProductName;
        TextView tvProductPrice;
        TextView tvProductStrikePrice;
        Button btnAddToBag;
        ImageView imProduct;
        View itemView;
        ProgressBar progressBar;
        public ProductListViewHolderLinear(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=-1) {

                        productListOnClick.getPosition(getAdapterPosition());
                    }
                }
            });
            itemView.findViewById(R.id.btn_view_details).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=-1) {

                        productListOnClick.getPosition(getAdapterPosition());
                    }
                }
            });
        }
        public void bind(ProductsItem productsItem){

            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
            tvProductStrikePrice = itemView.findViewById(R.id.tv_product_strike_price);
            imProduct = itemView.findViewById(R.id.im_product);
            progressBar = itemView.findViewById(R.id.progress_bar_item_list);
            Glide.with(imProduct.getContext()).load(productsItem.getImages().get(0)).into(imProduct);
            tvProductName.setText(productsItem.getName());
            tvProductPrice.setText(productsItem.getPrice().getPriceDisplay());
            if(productsItem.getPrice().getStrikeThroughPriceDisplay()!=null) {

                tvProductStrikePrice.setVisibility(View.VISIBLE);
                tvProductStrikePrice.setText(productsItem.getPrice().getStrikeThroughPriceDisplay());
                tvProductStrikePrice.setPaintFlags(tvProductStrikePrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else{

                tvProductStrikePrice.setVisibility(View.GONE);
            }
            if(typeOfClass==1) {

                if((getAdapterPosition()+1)%20==0) {

                    productListOnClick.loadingDetails(itemView);
                }

            }

        }
    }
    public class ProductListViewHolderGrid extends RecyclerView.ViewHolder{

        TextView tvProductName;
        TextView tvProductPrice;
        TextView tvProductStrikePrice;
        Button btnAddToBag;
        ImageView imProduct;
        View itemView;
        ProgressBar progressBar;
        public ProductListViewHolderGrid(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=-1) {
                        productListOnClick.getPosition(getAdapterPosition());
                    }
                }
            });
            itemView.findViewById(R.id.btn_view_details).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=-1) {
                        productListOnClick.getPosition(getAdapterPosition());
                    }
                }
            });
        }
        public void bind(ProductsItem productsItem){

            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
            tvProductStrikePrice = itemView.findViewById(R.id.tv_product_strike_price);
            imProduct = itemView.findViewById(R.id.im_product);
            progressBar = itemView.findViewById(R.id.progress_bar_item_list);

            Glide.with(imProduct.getContext()).load(productsItem.getImages().get(0)).into(imProduct);
            tvProductName.setText(productsItem.getName());
            tvProductPrice.setText(productsItem.getPrice().getPriceDisplay());
            if(productsItem.getPrice().getStrikeThroughPriceDisplay()!=null) {

                tvProductStrikePrice.setVisibility(View.VISIBLE);
                tvProductStrikePrice.setText(productsItem.getPrice().getStrikeThroughPriceDisplay());
                tvProductStrikePrice.setPaintFlags(tvProductStrikePrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            }
            else{

                tvProductStrikePrice.setVisibility(View.GONE);
            }
            if(typeOfClass==1) {

                if((getAdapterPosition()+1)%20==0) {

                    productListOnClick.loadingDetails(itemView);
                }

            }

        }
    }

    public interface ProductListOnClick{
        void getPosition(int position);
        void loadingDetails(View view);
        int getTypeOfLayout();
    }
}
