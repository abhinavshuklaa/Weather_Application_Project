package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {



    @GET("/api/location/search/")
    Call<List<ResponseDryRun>> enterName(@Query("query") String enterName);
//
//    @GET("/api/location/{woeid}/")
//    Call<WeatherReport> enterWoeidData(@Path("woeid") long woeidNumber);

    @GET("/api/location/{woeid}/")
    Call<ResponseModelSecondActivity> getListOfResponse(@Path("woeid") long woeidNumber);

}
