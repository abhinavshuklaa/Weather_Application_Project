package com.example.myapplication;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDryRun implements Serializable {

	@SerializedName("latt_long")
	private String lattLong;

	@SerializedName("woeid")
	private int woeid;

	public ResponseDryRun(String lattLong, int woeid, String title, String locationType) {
		this.lattLong = lattLong;
		this.woeid = woeid;
		this.title = title;
		this.locationType = locationType;
	}

	@SerializedName("title")
	private String title;

	@SerializedName("location_type")
	private String locationType;

	public String getLattLong(){
		return lattLong;
	}

	public int getWoeid(){
		return woeid;
	}

	public String getTitle(){
		return title;
	}

	public String getLocationType(){
		return locationType;
	}
}