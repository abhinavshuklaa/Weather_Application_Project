package com.example.myapplication;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ConsolidatedWeatherItem implements Serializable {

	@SerializedName("id")
	private long id;

	@SerializedName("weather_state_name")
	private String weatherStateName;

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
	private int airPressure;

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

	public int getAirPressure(){
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