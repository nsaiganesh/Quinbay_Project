package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProductsItem implements Serializable {

	@SerializedName("storeClosingInfo")
	private StoreClosingInfo storeClosingInfo;

	@SerializedName("expandedProducts")
	private List<Object> expandedProducts;

	@SerializedName("soldRangeCount")
	private SoldRangeCount soldRangeCount;

	@SerializedName("isCheap")
	private boolean isCheap;

	@SerializedName("official")
	private boolean official;

	@SerializedName("merchantVoucherMessage")
	private String merchantVoucherMessage;

	@SerializedName("numLocations")
	private int numLocations;

	@SerializedName("merchantName")
	private String merchantName;

	@SerializedName("price")
	private Price price;

	@SerializedName("review")
	private Review review;

	@SerializedName("level0Id")
	private String level0Id;

	@SerializedName("id")
	private String id;

	@SerializedName("sku")
	private String sku;

	@SerializedName("brand")
	private String brand;

	@SerializedName("merchantVoucherCount")
	private int merchantVoucherCount;

	@SerializedName("productFeatures")
	private String productFeatures;

	@SerializedName("promoEndTime")
	private long promoEndTime;

	@SerializedName("categoryIdHierarchy")
	private List<String> categoryIdHierarchy;

	@SerializedName("merchantCode")
	private String merchantCode;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("formattedId")
	private String formattedId;

	@SerializedName("itemSku")
	private String itemSku;

	@SerializedName("uniqueSellingPoint")
	private String uniqueSellingPoint;

	@SerializedName("cartLogisticOptions")
	private List<Object> cartLogisticOptions;

	@SerializedName("url")
	private String url;

	@SerializedName("itemCount")
	private int itemCount;

	@SerializedName("defaultSku")
	private String defaultSku;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("badge")
	private Badge badge;

	@SerializedName("allCategories")
	private List<String> allCategories;

	@SerializedName("name")
	private String name;

	@SerializedName("attributes")
	private List<AttributesItem> attributes;

	@SerializedName("debugData")
	private DebugData debugData;

	@SerializedName("location")
	private String location;

	@SerializedName("rootCategory")
	private RootCategory rootCategory;

	@SerializedName("preorder")
	private boolean preorder;

	@SerializedName("status")
	private String status;
	@SerializedName("desc")
	private String desc;
	public String getDesc()
	{
		return desc;
	}

	public StoreClosingInfo getStoreClosingInfo(){
		return storeClosingInfo;
	}

	public List<Object> getExpandedProducts(){
		return expandedProducts;
	}

	public SoldRangeCount getSoldRangeCount(){
		return soldRangeCount;
	}

	public boolean isIsCheap(){
		return isCheap;
	}

	public boolean isOfficial(){
		return official;
	}

	public String getMerchantVoucherMessage(){
		return merchantVoucherMessage;
	}

	public int getNumLocations(){
		return numLocations;
	}

	public String getMerchantName(){
		return merchantName;
	}

	public Price getPrice(){
		return price;
	}

	public Review getReview(){
		return review;
	}

	public String getLevel0Id(){
		return level0Id;
	}

	public String getId(){
		return id;
	}

	public String getSku(){
		return sku;
	}

	public String getBrand(){
		return brand;
	}

	public int getMerchantVoucherCount(){
		return merchantVoucherCount;
	}

	public String getProductFeatures(){
		return productFeatures;
	}

	public long getPromoEndTime(){
		return promoEndTime;
	}

	public List<String> getCategoryIdHierarchy(){
		return categoryIdHierarchy;
	}

	public String getMerchantCode(){
		return merchantCode;
	}

	public List<String> getImages(){
		return images;
	}

	public String getFormattedId(){
		return formattedId;
	}

	public String getItemSku(){
		return itemSku;
	}

	public String getUniqueSellingPoint(){
		return uniqueSellingPoint;
	}

	public List<Object> getCartLogisticOptions(){
		return cartLogisticOptions;
	}

	public String getUrl(){
		return url;
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

	public List<String> getAllCategories(){
		return allCategories;
	}

	public String getName(){
		return name;
	}

	public List<AttributesItem> getAttributes(){
		return attributes;
	}

	public DebugData getDebugData(){
		return debugData;
	}

	public String getLocation(){
		return location;
	}

	public RootCategory getRootCategory(){
		return rootCategory;
	}

	public boolean isPreorder(){
		return preorder;
	}

	public String getStatus(){
		return status;
	}
}