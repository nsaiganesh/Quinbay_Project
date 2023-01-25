package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OptionsItem implements Serializable {

	@SerializedName("name")
	private String name;

	@SerializedName("label")
	private String label;

	@SerializedName("value")
	private int value;

	@SerializedName("selected")
	private boolean selected;

	public String getName(){
		return name;
	}

	public String getLabel(){
		return label;
	}

	public int getValue(){
		return value;
	}

	public boolean isSelected(){
		return selected;
	}
}