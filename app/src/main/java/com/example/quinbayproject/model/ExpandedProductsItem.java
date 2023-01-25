package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ExpandedProductsItem implements Serializable {

	@SerializedName("promoEndTime")
	private long promoEndTime;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("official")
	private boolean official;

	@SerializedName("merchantVoucherMessage")
	private String merchantVoucherMessage;

	@SerializedName("cartLogisticOptions")
	private List<Object> cartLogisticOptions;

	@SerializedName("url")
	private String url;

	@SerializedName("numLocations")
	private int numLocations;

	@SerializedName("itemCount")
	private int itemCount;

	@SerializedName("defaultSku")
	private String defaultSku;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("badge")
	private Badge badge;

	@SerializedName("price")
	private Price price;

	@SerializedName("review")
	private Review review;

	@SerializedName("merchantVoucherCount")
	private int merchantVoucherCount;

	@SerializedName("preorder")
	private boolean preorder;

	@SerializedName("status")
	private String status;

	public long getPromoEndTime(){
		return promoEndTime;
	}

	public List<String> getImages(){
		return images;
	}

	public boolean isOfficial(){
		return official;
	}

	public String getMerchantVoucherMessage(){
		return merchantVoucherMessage;
	}

	public List<Object> getCartLogisticOptions(){
		return cartLogisticOptions;
	}

	public String getUrl(){
		return url;
	}

	public int getNumLocations(){
		return numLocations;
	}

	public int getItemCount(){
		return itemCount;
	}

	public String getDefaultSku(){
		return defaultSku;
	}

	public List<String> getTags(){
		return tags;
	}

	public Badge getBadge(){
		return badge;
	}

	public Price getPrice(){
		return price;
	}

	public Review getReview(){
		return review;
	}

	public int getMerchantVoucherCount(){
		return merchantVoucherCount;
	}

	public boolean isPreorder(){
		return preorder;
	}

	public String getStatus(){
		return status;
	}
}