package com.example.myapplication;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ConsolidatedWeatherItem implements Serializable {

	@SerializedName("id")
	private long id;

	@SerializedName("weather_state_name")
	private String weatherStateName;

	public ConsolidatedWeatherItem(long id, String weatherStateName, String weatherStateAbbr, String windDirectionCompass, String created, String applicableDate, Object minTemp, Object maxTemp, Object theTemp, Object windSpeed, Object windDirection, float airPressure, int humidity, Object visibility, int predictability) {
		this.id = id;
		this.weatherStateName = weatherStateName;
		this.weatherStateAbbr = weatherStateAbbr;
		this.windDirectionCompass = windDirectionCompass;
		this.created = created;
		this.applicableDate = applicableDate;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.theTemp = theTemp;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.airPressure = airPressure;
		this.humidity = humidity;
		this.visibility = visibility;
		this.predictability = predictability;
	}

	@SerializedName("weather_state_abbr")
	private String weatherStateAbbr;

	@SerializedName("wind_direction_compass")
	private String windDirectionCompass;

	@SerializedName("created")
	private String created;

	@SerializedName("applicable_date")
	private String applicableDate;

	@SerializedName("min_temp")
	private Object minTemp;

	@SerializedName("max_temp")
	private Object maxTemp;

	@SerializedName("the_temp")
	private Object theTemp;

	@SerializedName("wind_speed")
	private Object windSpeed;

	@SerializedName("wind_direction")
	private Object windDirection;

	@SerializedName("air_pressure")
	private float airPressure;

	@SerializedName("humidity")
	private int humidity;

	@SerializedName("visibility")
	private Object visibility;

	@SerializedName("predictability")
	private int predictability;

	public long getId(){
		return id;
	}

	public String getWeatherStateName(){
		return weatherStateName;
	}

	public String getWeatherStateAbbr(){
		return weatherStateAbbr;
	}

	public String getWindDirectionCompass(){
		return windDirectionCompass;
	}

	public String getCreated(){
		return created;
	}

	public String getApplicableDate(){
		return applicableDate;
	}

	public Object getMinTemp(){
		return minTemp;
	}

	public Object getMaxTemp(){
		return maxTemp;
	}


	public Object getTheTemp(){
		return theTemp;
	}



	public Object getWindSpeed(){
		return windSpeed;
	}


	public Object getWindDirection(){
		return windDirection;
	}


	public float getAirPressure(){
		return airPressure;
	}

	public int getHumidity(){
		return humidity;
	}

	public Object getVisibility(){
		return visibility;
	}

	public int getPredictability(){
		return predictability;
	}

}

/*

	@SerializedName("weather_state_abbr")
	private String weatherStateAbbr;


	public String getWeatherStateAbbr(){
		return weatherStateAbbr;
	}
	String weatherStateAbbr
		this.weatherStateAbbr = weatherStateAbbr;


 */