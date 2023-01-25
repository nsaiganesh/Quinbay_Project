package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BAE7029700009 implements Serializable {

	@SerializedName("tags")
	private List<String> tags;

	public List<String> getTags(){
		return tags;
	}
}