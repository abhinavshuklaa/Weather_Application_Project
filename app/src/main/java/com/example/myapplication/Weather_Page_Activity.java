package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Weather_Page_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ApiAdapterSecondActivity apiAdapterSecondActivity;
    private List<ResponseModelSecondActivity> responseModelSecondActivityList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather__page_);
        initViews();
        setRecyclerAdapter();

    }

    private void setRecyclerAdapter() {
        apiAdapterSecondActivity = new ApiAdapterSecondActivity(responseModelSecondActivityList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(apiAdapterSecondActivity);

    }


    private void initViews() {
        recyclerView = findViewById(R.id.recyclerViewSecondActivity);


        ApiClient apiClient = Network.getRetrofitInstance(Weather_Page_Activity.this).create(ApiClient.class);
        Intent intent = getIntent();
        long data = intent.getLongExtra("data", -1);
//
//        Call<List<ResponseModelSecondActivity>> call=apiClient.getListOfResponse(data);
//            call.enqueue(new Callback<List<ResponseModelSecondActivity>>() {
//                @Override
//                public void onResponse(Call<List<ResponseModelSecondActivity>> call, Response<List<ResponseModelSecondActivity>> response) {
//                    if(response.code()== HttpURLConnection.HTTP_OK && response.body() != null) {
//
//                        apiAdapterSecondActivity.updateListSecondActivity(responseModelSecondActivityList);
//
//                    }
//                    }
//
//                @Override
//                public void onFailure(Call<List<ResponseModelSecondActivity>> call, Throwable t) {
//                    Toast.makeText(Weather_Page_Activity.this,"Response Failed" + t.getMessage(),Toast.LENGTH_SHORT).show();
//
//                }
//            });


        Call<WeatherReport> call = apiClient.enterWoeidData(data);
        call.enqueue(new Callback<WeatherReport>() {
            @Override
            public void onResponse(Call<WeatherReport> call, Response<WeatherReport> response) {
                if (response.body() != null) {
                    for (int i = 0; i < response.body().getConsolidatedWeather().size(); i++) {

                        String weatherState = response.body().getConsolidatedWeather().get(i).getWeatherStateName();
//                String windDirectionCompass, String applicableDate, float minTemp, Object maxTemp, Object windSpeed, float airPressure
                        String windDirectionCompass = response.body().getConsolidatedWeather().get(i).getWindDirectionCompass();
                        String applicableDate = response.body().getConsolidatedWeather().get(i).getApplicableDate();
                        double minTemp = (double) response.body().getConsolidatedWeather().get(i).getMinTemp();
                        double maxTemp = (double) response.body().getConsolidatedWeather().get(i).getMaxTemp();
                        double windSpeed = (double) response.body().getConsolidatedWeather().get(i).getWindDirection();
                        float airPressure = response.body().getConsolidatedWeather().get(i).getAirPressure();
                        String weather_state_abbr = response.body().getConsolidatedWeather().get(i).getWeatherStateAbbr();

                        //String weatherStateName, String windDirectionCompass, String applicableDate, double minTemp, double maxTemp, double windSpeed, float airPressure,String weatherStateAbbr

                        responseModelSecondActivityList.add(new ResponseModelSecondActivity(weatherState, windDirectionCompass, applicableDate, minTemp, maxTemp, windSpeed, airPressure, weather_state_abbr));

                    }
                    apiAdapterSecondActivity.updateListSecondActivity(responseModelSecondActivityList);
                }
            }


            @Override
            public void onFailure(Call<WeatherReport> call, Throwable t) {
                Toast.makeText(Weather_Page_Activity.this, "Response Failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//
//
//        Call<WeatherReport> call=apiClient.enterWoeidData(data);
//        call.enqueue(new Callback<WeatherReport>() {
//            @Override
//            public void onResponse(Call<WeatherReport> call, Response<WeatherReport> response) {
//                if(response.code()== HttpURLConnection.HTTP_OK && response.body() != null){
//                    WeatherReport weatherReport=response.body();
//                    tvGetWeatherStatus.setText(weatherReport.getTimezone());
//                    tvGetAirPressure.setText(weatherReport.getTime());
//                    tvGetPredictability.setText(weatherReport.getLocationType());
//                    tvGetWindDirection.setText(weatherReport.getSunRise());
////
////                    for(int i=0;i<response.body().getConsolidatedWeather().size();i++){
////                        tvGetAirPressure.setText( response.body().getConsolidatedWeather().get(i).getapplicable());
////                        break;
////                    }
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<WeatherReport> call, Throwable t) {
//                Toast.makeText(Weather_Page_Activity.this,"Response Failed" + t.getMessage(),Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }
}