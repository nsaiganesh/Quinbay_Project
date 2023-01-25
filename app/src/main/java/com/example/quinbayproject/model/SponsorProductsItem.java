package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SponsorProductsItem implements Serializable {

	@SerializedName("salePrice")
	private Object salePrice;

	@SerializedName("uclid")
	private String uclid;

	@SerializedName("soldRangeCount")
	private SoldRangeCount soldRangeCount;

	@SerializedName("discount")
	private int discount;

	@SerializedName("official")
	private boolean official;

	@SerializedName("mrp")
	private Object mrp;

	@SerializedName("destinationUrl")
	private String destinationUrl;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("badge")
	private Badge badge;

	@SerializedName("score")
	private int score;

	@SerializedName("sellerId")
	private String sellerId;

	@SerializedName("sclid")
	private String sclid;

	@SerializedName("review")
	private Review review;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("rank")
	private int rank;

	@SerializedName("location")
	private String location;

	@SerializedName("skuId")
	private String skuId;

	public Object getSalePrice(){
		return salePrice;
	}

	public String getUclid(){
		return uclid;
	}

	public SoldRangeCount getSoldRangeCount(){
		return soldRangeCount;
	}

	public int getDiscount(){
		return discount;
	}

	public boolean isOfficial(){
		return official;
	}

	public Object getMrp(){
		return mrp;
	}

	public String getDestinationUrl(){
		return destinationUrl;
	}

	public List<String> getTags(){
		return tags;
	}

	public Badge getBadge(){
		return badge;
	}

	public int getScore(){
		return score;
	}

	public String getSellerId(){
		return sellerId;
	}

	public String getSclid(){
		return sclid;
	}

	public Review getReview(){
		return review;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public String getName(){
		return name;
	}

	public int getRank(){
		return rank;
	}

	public String getLocation(){
		return location;
	}

	public String getSkuId(){
		return skuId;
	}
}