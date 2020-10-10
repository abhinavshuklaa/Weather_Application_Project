package com.example.myapplication;


import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WeatherReport implements Serializable {

	@SerializedName("consolidated_weather")
	private List<ConsolidatedWeatherItem> consolidatedWeather;

	@SerializedName("time")
	private String time;

	public WeatherReport(List<ConsolidatedWeatherItem> consolidatedWeather, String time, String sunRise, String sunSet, String timezoneName, Parent parent, List<SourcesItem> sources, String title, String locationType, int woeid, String lattLong, String timezone) {
		this.consolidatedWeather = consolidatedWeather;
		this.time = time;
		this.sunRise = sunRise;
		this.sunSet = sunSet;
		this.timezoneName = timezoneName;
		this.parent = parent;
		this.sources = sources;
		this.title = title;
		this.locationType = locationType;
		this.woeid = woeid;
		this.lattLong = lattLong;
		this.timezone = timezone;
	}


	@SerializedName("sun_rise")
	private String sunRise;

	@SerializedName("sun_set")
	private String sunSet;

	@SerializedName("timezone_name")
	private String timezoneName;

	@SerializedName("parent")
	private Parent parent;

	@SerializedName("sources")
	private List<SourcesItem> sources;

	@SerializedName("title")
	private String title;

	@SerializedName("location_type")
	private String locationType;

	@SerializedName("woeid")
	private int woeid;

	@SerializedName("latt_long")
	private String lattLong;

	@SerializedName("timezone")
	private String timezone;

	public List<ConsolidatedWeatherItem> getConsolidatedWeather(){
		return consolidatedWeather;
	}

	public String getTime(){
		return time;
	}

	public String getSunRise(){
		return sunRise;
	}

	public String getSunSet(){
		return sunSet;
	}

	public String getTimezoneName(){
		return timezoneName;
	}

	public Parent getParent(){
		return parent;
	}

	public List<SourcesItem> getSources(){
		return sources;
	}

	public String getTitle(){
		return title;
	}

	public String getLocationType(){
		return locationType;
	}

	public int getWoeid(){
		return woeid;
	}

	public String getLattLong(){
		return lattLong;
	}

	public String getTimezone(){
		return timezone;
	}
}