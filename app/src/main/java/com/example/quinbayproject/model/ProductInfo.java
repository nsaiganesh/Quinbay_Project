package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductInfo implements Serializable {

	@SerializedName("BLP-60045-00314")
	private BLP6004500314 bLP6004500314;

	@SerializedName("GAT-70141-00001")
	private GAT7014100001 gAT7014100001;

	@SerializedName("SAO-60034-02001")
	private SAO6003402001 sAO6003402001;

	@SerializedName("BLW-70014-00004")
	private BLW7001400004 bLW7001400004;

	@SerializedName("SAO-60034-01468")
	private SAO6003401468 sAO6003401468;

	@SerializedName("BAE-70297-00009")
	private BAE7029700009 bAE7029700009;

	@SerializedName("RAS-60118-00311")
	private RAS6011800311 rAS6011800311;

	public BLP6004500314 getBLP6004500314(){
		return bLP6004500314;
	}

	public GAT7014100001 getGAT7014100001(){
		return gAT7014100001;
	}

	public SAO6003402001 getSAO6003402001(){
		return sAO6003402001;
	}

	public BLW7001400004 getBLW7001400004(){
		return bLW7001400004;
	}

	public SAO6003401468 getSAO6003401468(){
		return sAO6003401468;
	}

	public BAE7029700009 getBAE7029700009(){
		return bAE7029700009;
	}

	public RAS6011800311 getRAS6011800311(){
		return rAS6011800311;
	}
}