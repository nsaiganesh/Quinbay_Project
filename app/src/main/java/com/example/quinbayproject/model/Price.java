package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Price implements Serializable {

	@SerializedName("priceDisplay")
	private String priceDisplay;

	@SerializedName("offerPriceDisplay")
	private String offerPriceDisplay;

	@SerializedName("minPrice")
	private Object minPrice;

	@SerializedName("discount")
	private int discount;

	@SerializedName("strikeThroughPriceDisplay")
	private String strikeThroughPriceDisplay;

	public String getPriceDisplay(){
		return priceDisplay;
	}

	public String getOfferPriceDisplay(){
		return offerPriceDisplay;
	}

	public Object getMinPrice(){
		return minPrice;
	}

	public int getDiscount(){
		return discount;
	}

	public String getStrikeThroughPriceDisplay(){
		return strikeThroughPriceDisplay;
	}
}