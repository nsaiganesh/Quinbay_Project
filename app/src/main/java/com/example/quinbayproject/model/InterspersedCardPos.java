package com.example.quinbayproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InterspersedCardPos implements Serializable {

	@SerializedName("ROM")
	private int rOM;

	@SerializedName("Memori Internal")
	private int memoriInternal;

	@SerializedName("Ukuran")
	private int ukuran;

	@SerializedName("Optical Zoom")
	private int opticalZoom;

	@SerializedName("Kondisi Produk")
	private int kondisiProduk;

	@SerializedName("Lokasi toko")
	private int lokasiToko;

	@SerializedName("Warna")
	private int warna;

	@SerializedName("RAM")
	private int rAM;

	public int getROM(){
		return rOM;
	}

	public int getMemoriInternal(){
		return memoriInternal;
	}

	public int getUkuran(){
		return ukuran;
	}

	public int getOpticalZoom(){
		return opticalZoom;
	}

	public int getKondisiProduk(){
		return kondisiProduk;
	}

	public int getLokasiToko(){
		return lokasiToko;
	}

	public int getWarna(){
		return warna;
	}

	public int getRAM(){
		return rAM;
	}
}