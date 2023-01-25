package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SoldRangeCount implements Serializable {

	@SerializedName("en")
	private String en;

	@SerializedName("id")
	private String id;

	public String getEn(){
		return en;
	}

	public String getId(){
		return id;
	}
}