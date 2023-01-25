package com.example.quinbayproject.model2;

import com.google.gson.annotations.SerializedName;

public class ProductsDtoListItem{

	@SerializedName("productId")
	private String productId;

	@SerializedName("merchantId")
	private String merchantId;

	@SerializedName("price")
	private Object price;

	@SerializedName("imageURL")
	private String imageURL;

	@SerializedName("brand")
	private Object brand;

	@SerializedName("productName")
	private String productName;

	@SerializedName("productDescription")
	private String productDescription;

	@SerializedName("categoryId")
	private String categoryId;

	@SerializedName("merchantName")
	private String merchantName;

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setPrice(Object price){
		this.price = price;
	}

	public Object getPrice(){
		return price;
	}

	public void setImageURL(String imageURL){
		this.imageURL = imageURL;
	}

	public String getImageURL(){
		return imageURL;
	}

	public void setBrand(Object brand){
		this.brand = brand;
	}

	public Object getBrand(){
		return brand;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setMerchantName(String merchantName){
		this.merchantName = merchantName;
	}

	public String getMerchantName(){
		return merchantName;
	}

	@Override
 	public String toString(){
		return 
			"ProductsDtoListItem{" + 
			"productId = '" + productId + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",price = '" + price + '\'' + 
			",imageURL = '" + imageURL + '\'' + 
			",brand = '" + brand + '\'' + 
			",productName = '" + productName + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",merchantName = '" + merchantName + '\'' + 
			"}";
		}
}