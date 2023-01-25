package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SAO6003402001 implements Serializable {

	@SerializedName("tags")
	private List<String> tags;

	public List<String> getTags(){
		return tags;
	}
}