package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDryRun implements Serializable, Parcelable {

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

	protected ResponseDryRun(Parcel in) {
		lattLong = in.readString();
		woeid = in.readInt();
		title = in.readString();
		locationType = in.readString();
	}

	public static final Creator<ResponseDryRun> CREATOR = new Creator<ResponseDryRun>() {
		@Override
		public ResponseDryRun createFromParcel(Parcel in) {
			return new ResponseDryRun(in);
		}

		@Override
		public ResponseDryRun[] newArray(int size) {
			return new ResponseDryRun[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(lattLong);
		parcel.writeInt(woeid);
		parcel.writeString(title);
		parcel.writeString(locationType);
	}
}