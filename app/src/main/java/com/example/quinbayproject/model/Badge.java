package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Badge implements Serializable {

	@SerializedName("merchantBadge")
	private String merchantBadge;

	@SerializedName("merchantBadgeUrl")
	private String merchantBadgeUrl;

	public String getMerchantBadge(){
		return merchantBadge;
	}

	public String getMerchantBadgeUrl(){
		return merchantBadgeUrl;
	}
}