package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Sorting implements Serializable {

	@SerializedName("parameter")
	private String parameter;

	@SerializedName("options")
	private List<OptionsItem> options;

	public String getParameter(){
		return parameter;
	}

	public List<OptionsItem> getOptions(){
		return options;
	}
}