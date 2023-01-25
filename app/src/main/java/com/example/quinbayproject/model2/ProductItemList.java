package com.example.quinbayproject.model2;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductItemList{

	@SerializedName("productsDtoList")
	private List<ProductsDtoListItem> productsDtoList;

	public void setProductsDtoList(List<ProductsDtoListItem> productsDtoList){
		this.productsDtoList = productsDtoList;
	}

	public List<ProductsDtoListItem> getProductsDtoList(){
		return productsDtoList;
	}

	@Override
 	public String toString(){
		return 
			"ProductItemList{" + 
			"productsDtoList = '" + productsDtoList + '\'' + 
			"}";
		}
}