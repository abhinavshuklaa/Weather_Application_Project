package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Weather_Page_Activity extends AppCompatActivity {
    private TextView tvGetWeatherStatus;
    private TextView tvGetWindDirection;
    private TextView tvGetAirPressure;
    private TextView tvGetPredictability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather__page_);
        initViews();

    }

    private void initViews() {
        tvGetWeatherStatus=findViewById(R.id.tvGetWeatherStatus);
        tvGetWindDirection=findViewById(R.id.tvGetWindDirection);
        tvGetAirPressure=findViewById(R.id.tvGetAirPressure);
        tvGetPredictability=findViewById(R.id.tvGetPredictability);


        ApiClient apiClient=Network.getRetrofitInstance(Weather_Page_Activity.this).create(ApiClient.class);

        Call<WeatherReport> call=apiClient.enterWoeidData(getIntent().getLongExtra("woeid",0));
        call.enqueue(new Callback<WeatherReport>() {
            @Override
            public void onResponse(Call<WeatherReport> call, Response<WeatherReport> response) {
                if(response.code()== HttpURLConnection.HTTP_OK && response.body() != null){
                    WeatherReport weatherReport=response.body();
                    tvGetWeatherStatus.setText(weatherReport.getSunRise());
//                    tvGetAirPressure.setText(weatherReport.get);

                }
            }

            @Override
            public void onFailure(Call<WeatherReport> call, Throwable t) {

            }
        });

    }
}