package com.example.quinbayproject.adapter;

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
import com.example.quinbayproject.model2.ProductsDtoListItem;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>{

        List<ProductsDtoListItem> productsItem;

        ProductListOnClick productListOnClick;
        public CategoryListAdapter(List<ProductsDtoListItem> productItem, ProductListOnClick productListOnClick){

            this.productsItem = productItem;
            this.productListOnClick = productListOnClick;
        }
        @NonNull
        @Override
        public CategoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_details_linear,parent,false);
            return new CategoryListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryListViewHolder holder, int position) {
                holder.bind(productsItem.get(position));
        }

        @Override
        public int getItemCount() {

            return productsItem.size();
        }

        public class CategoryListViewHolder extends RecyclerView.ViewHolder{

            TextView tvProductName;
            TextView tvProductPrice;
            TextView tvProductStrikePrice;
            Button btnAddToBag;
            ImageView imProduct;
            View itemView;
            ProgressBar progressBar;
            public CategoryListViewHolder(@NonNull View itemView) {
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
            public void bind(ProductsDtoListItem productsItem){

                tvProductName = itemView.findViewById(R.id.tv_product_name);
                tvProductPrice = itemView.findViewById(R.id.tv_product_price);
                tvProductStrikePrice = itemView.findViewById(R.id.tv_product_strike_price);
                imProduct = itemView.findViewById(R.id.im_product);
                progressBar = itemView.findViewById(R.id.progress_bar_item_list);
                Glide.with(imProduct.getContext()).load(productsItem.getImageURL()).into(imProduct);
                tvProductName.setText(productsItem.getProductName());
                tvProductPrice.setText(productsItem.getPrice().toString());
//                if(productsItem.getPrice().getStrikeThroughPriceDisplay()!=null) {
//
//                    tvProductStrikePrice.setVisibility(View.VISIBLE);
//                    tvProductStrikePrice.setText(productsItem.getPrice().getStrikeThroughPriceDisplay());
//                    tvProductStrikePrice.setPaintFlags(tvProductStrikePrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
//                }
//                else{
//
//                    tvProductStrikePrice.setVisibility(View.GONE);
//                }

            }
        }
        public interface ProductListOnClick{
            void getPosition(int position);
        }
}
