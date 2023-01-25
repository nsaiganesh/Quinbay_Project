package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {

	@SerializedName("relatedSearchTermsPosition")
	private int relatedSearchTermsPosition;

	@SerializedName("code")
	private String code;

	@SerializedName("productsPerRow")
	private int productsPerRow;

	@SerializedName("showRestrictedMsg")
	private boolean showRestrictedMsg;

	@SerializedName("interspersedCardPos")
	private InterspersedCardPos interspersedCardPos;

	@SerializedName("sellerNewSectionResponse")
	private SellerNewSectionResponse sellerNewSectionResponse;

	@SerializedName("materiallResponse")
	private boolean materiallResponse;

	@SerializedName("searchPageUrl")
	private String searchPageUrl;

	@SerializedName("responseFlags")
	private List<Object> responseFlags;

	@SerializedName("sellerAdsPosition")
	private List<Integer> sellerAdsPosition;

	@SerializedName("products")
	private List<ProductsItem> products;

	@SerializedName("intentApplied")
	private boolean intentApplied;

	@SerializedName("sponsorProducts")
	private List<SponsorProductsItem> sponsorProducts;

	@SerializedName("intentAttributes")
	private IntentAttributes intentAttributes;

	@SerializedName("sellerAdsPositionWebListView")
	private List<Integer> sellerAdsPositionWebListView;

	@SerializedName("nearbyLocationFailed")
	private boolean nearbyLocationFailed;

	@SerializedName("pageType")
	private List<Object> pageType;

	@SerializedName("searchTerm")
	private String searchTerm;

	@SerializedName("sorting")
	private Sorting sorting;

	@SerializedName("pageMetaDataResponse")
	private PageMetaDataResponse pageMetaDataResponse;

	@SerializedName("redirectionUrl")
	private String redirectionUrl;

	@SerializedName("ageRestricted")
	private boolean ageRestricted;

	@SerializedName("quickFilters")
	private List<Object> quickFilters;

	@SerializedName("maxOffers")
	private int maxOffers;

	@SerializedName("correctedSearchResponses")
	private List<Object> correctedSearchResponses;

	@SerializedName("nerApplied")
	private boolean nerApplied;

	@SerializedName("nerAttributes")
	private NerAttributes nerAttributes;

	@SerializedName("catIntentFailed")
	private boolean catIntentFailed;

	@SerializedName("paging")
	private Paging paging;

	@SerializedName("pageMetadata")
	private PageMetadata pageMetadata;

	@SerializedName("filters")
	private List<Object> filters;

	@SerializedName("sellerNewProducts")
	private List<Object> sellerNewProducts;

	@SerializedName("productInfo")
	private ProductInfo productInfo;

	@SerializedName("interspersedCardFilters")
	private List<Object> interspersedCardFilters;

	@SerializedName("selectedCategoryIds")
	private List<Object> selectedCategoryIds;

	@SerializedName("showAllCategories")
	private boolean showAllCategories;

	@SerializedName("suggestions")
	private List<Object> suggestions;

	@SerializedName("serverCurrentTime")
	private long serverCurrentTime;

	@SerializedName("trackerFields")
	private TrackerFields trackerFields;

	@SerializedName("topRatedProduct")
	private TopRatedProduct topRatedProduct;

	@SerializedName("needMoreSearchResponse")
	private boolean needMoreSearchResponse;

	@SerializedName("correctedNearbyLocation")
	private String correctedNearbyLocation;

	public int getRelatedSearchTermsPosition(){
		return relatedSearchTermsPosition;
	}

	public String getCode(){
		return code;
	}

	public int getProductsPerRow(){
		return productsPerRow;
	}

	public boolean isShowRestrictedMsg(){
		return showRestrictedMsg;
	}

	public InterspersedCardPos getInterspersedCardPos(){
		return interspersedCardPos;
	}

	public SellerNewSectionResponse getSellerNewSectionResponse(){
		return sellerNewSectionResponse;
	}

	public boolean isMateriallResponse(){
		return materiallResponse;
	}

	public String getSearchPageUrl(){
		return searchPageUrl;
	}

	public List<Object> getResponseFlags(){
		return responseFlags;
	}

	public List<Integer> getSellerAdsPosition(){
		return sellerAdsPosition;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}

	public boolean isIntentApplied(){
		return intentApplied;
	}

	public List<SponsorProductsItem> getSponsorProducts(){
		return sponsorProducts;
	}

	public IntentAttributes getIntentAttributes(){
		return intentAttributes;
	}

	public List<Integer> getSellerAdsPositionWebListView(){
		return sellerAdsPositionWebListView;
	}

	public boolean isNearbyLocationFailed(){
		return nearbyLocationFailed;
	}

	public List<Object> getPageType(){
		return pageType;
	}

	public String getSearchTerm(){
		return searchTerm;
	}

	public Sorting getSorting(){
		return sorting;
	}

	public PageMetaDataResponse getPageMetaDataResponse(){
		return pageMetaDataResponse;
	}

	public String getRedirectionUrl(){
		return redirectionUrl;
	}

	public boolean isAgeRestricted(){
		return ageRestricted;
	}

	public List<Object> getQuickFilters(){
		return quickFilters;
	}

	public int getMaxOffers(){
		return maxOffers;
	}

	public List<Object> getCorrectedSearchResponses(){
		return correctedSearchResponses;
	}

	public boolean isNerApplied(){
		return nerApplied;
	}

	public NerAttributes getNerAttributes(){
		return nerAttributes;
	}

	public boolean isCatIntentFailed(){
		return catIntentFailed;
	}

	public Paging getPaging(){
		return paging;
	}

	public PageMetadata getPageMetadata(){
		return pageMetadata;
	}

	public List<Object> getFilters(){
		return filters;
	}

	public List<Object> getSellerNewProducts(){
		return sellerNewProducts;
	}

	public ProductInfo getProductInfo(){
		return productInfo;
	}

	public List<Object> getInterspersedCardFilters(){
		return interspersedCardFilters;
	}

	public List<Object> getSelectedCategoryIds(){
		return selectedCategoryIds;
	}

	public boolean isShowAllCategories(){
		return showAllCategories;
	}

	public List<Object> getSuggestions(){
		return suggestions;
	}

	public long getServerCurrentTime(){
		return serverCurrentTime;
	}

	public TrackerFields getTrackerFields(){
		return trackerFields;
	}

	public TopRatedProduct getTopRatedProduct(){
		return topRatedProduct;
	}

	public boolean isNeedMoreSearchResponse(){
		return needMoreSearchResponse;
	}

	public String getCorrectedNearbyLocation(){
		return correctedNearbyLocation;
	}
}