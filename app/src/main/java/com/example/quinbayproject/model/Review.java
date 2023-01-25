package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Review implements Serializable {

	@SerializedName("absoluteRating")
	private Object absoluteRating;

	@SerializedName("rating")
	private int rating;

	@SerializedName("count")
	private int count;

	public Object getAbsoluteRating(){
		return absoluteRating;
	}

	public int getRating(){
		return rating;
	}

	public int getCount(){
		return count;
	}
}