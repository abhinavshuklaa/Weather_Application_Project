package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {



    @GET("/api/location/search/")
    Call<List<ResponseDryRun>> enterName(@Query("query") String enterName);

    @GET("/api/location/{woeid}/")

    Call<WeatherReport> enterWoeidData(@Path("woeid") long woeidNumber);

//
//    @GET("/api/v2.1/cities")
//    Call<List<ResponseDryRun>> getCities(@Header("user-key") String apiKey, @Query("q") String enterCity);


//    @GET("/api/location/{woeid}/")
//    Call<List<ResponseModelSecondActivity>> getListOfResponse(@Path("woeid") long woeidNumber);

}
