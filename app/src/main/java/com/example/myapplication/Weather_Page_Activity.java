package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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
        Intent intent=getIntent();
        long data=intent.getLongExtra("data",-1);



        Call<WeatherReport> call=apiClient.enterWoeidData(data);
        call.enqueue(new Callback<WeatherReport>() {
            @Override
            public void onResponse(Call<WeatherReport> call, Response<WeatherReport> response) {
                if(response.code()== HttpURLConnection.HTTP_OK && response.body() != null){
                    WeatherReport weatherReport=response.body();
                    tvGetWeatherStatus.setText(weatherReport.getTimezone());
                    tvGetAirPressure.setText(weatherReport.getTime());
                    tvGetPredictability.setText(weatherReport.getLocationType());
                    tvGetWindDirection.setText(weatherReport.getSunRise());
//
//                    for(float i=0;i<response.body().getConsolidatedWeather().size();i++){
//                        tvGetAirPressure.setText((int) response.body().getConsolidatedWeather().get((int) i).getAirPressure());
//                        break;
//                    }


                }
            }

            @Override
            public void onFailure(Call<WeatherReport> call, Throwable t) {
                Toast.makeText(Weather_Page_Activity.this,"Response Failed" + t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}