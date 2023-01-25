package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class C2SimilarityMap implements Serializable {

	@SerializedName("KA-1000004")
	private List<String> kA1000004;

	@SerializedName("KA-1000002")
	private List<String> kA1000002;

	@SerializedName("TA-1000003")
	private List<String> tA1000003;

	@SerializedName("HA-1000002")
	private List<String> hA1000002;

	@SerializedName("TU-1000021")
	private List<String> tU1000021;

	public List<String> getKA1000004(){
		return kA1000004;
	}

	public List<String> getKA1000002(){
		return kA1000002;
	}

	public List<String> getTA1000003(){
		return tA1000003;
	}

	public List<String> getHA1000002(){
		return hA1000002;
	}

	public List<String> getTU1000021(){
		return tU1000021;
	}
}