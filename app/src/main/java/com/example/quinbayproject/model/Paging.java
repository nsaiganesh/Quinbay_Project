package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Paging implements Serializable {

	@SerializedName("total_item")
	private int totalItem;

	@SerializedName("total_page")
	private int totalPage;

	@SerializedName("page")
	private int page;

	@SerializedName("item_per_page")
	private int itemPerPage;

	public int getTotalItem(){
		return totalItem;
	}

	public int getTotalPage(){
		return totalPage;
	}

	public int getPage(){
		return page;
	}

	public int getItemPerPage(){
		return itemPerPage;
	}
}