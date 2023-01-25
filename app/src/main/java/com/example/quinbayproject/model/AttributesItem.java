package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AttributesItem implements Serializable {

	@SerializedName("values")
	private List<String> values;

	@SerializedName("count")
	private int count;

	@SerializedName("optionListingType")
	private String optionListingType;

	public List<String> getValues(){
		return values;
	}

	public int getCount(){
		return count;
	}

	public String getOptionListingType(){
		return optionListingType;
	}
}