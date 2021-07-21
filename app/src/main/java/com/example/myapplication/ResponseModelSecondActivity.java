package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseModelSecondActivity implements Serializable {

    @SerializedName("weather_state_name")
    private String weatherStateName;


    @SerializedName("wind_direction_compass")
    private String windDirectionCompass;

    public ResponseModelSecondActivity(String weatherStateName, String windDirectionCompass, String applicableDate, double minTemp, double maxTemp, double windSpeed, float airPressure) {
        this.weatherStateName = weatherStateName;
        this.windDirectionCompass = windDirectionCompass;
        this.applicableDate = applicableDate;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.windSpeed = windSpeed;
        this.airPressure = airPressure;
    }

    @SerializedName("applicable_date")
    private String applicableDate;

    @SerializedName("min_temp")
    private double minTemp;

    @SerializedName("max_temp")
    private double maxTemp;


    @SerializedName("wind_speed")
    private double windSpeed;

    @SerializedName("air_pressure")
    private float airPressure;


    public String getWeatherStateName() {
        return weatherStateName;
    }

    public String getWindDirectionCompass() {
        return windDirectionCompass;
    }

    public String getApplicableDate() {
        return applicableDate;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public float getAirPressure() {
        return airPressure;
    }
}
