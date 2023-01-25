package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SellerNewSectionResponse implements Serializable {

	@SerializedName("newSellerProdBadge")
	private String newSellerProdBadge;

	@SerializedName("newSellerProdBg")
	private String newSellerProdBg;

	@SerializedName("newSellerProdSecRow")
	private int newSellerProdSecRow;

	@SerializedName("newSellerProdTitle")
	private String newSellerProdTitle;

	public String getNewSellerProdBadge(){
		return newSellerProdBadge;
	}

	public String getNewSellerProdBg(){
		return newSellerProdBg;
	}

	public int getNewSellerProdSecRow(){
		return newSellerProdSecRow;
	}

	public String getNewSellerProdTitle(){
		return newSellerProdTitle;
	}
}