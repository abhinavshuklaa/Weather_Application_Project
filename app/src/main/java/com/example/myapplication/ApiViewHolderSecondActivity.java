package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ApiViewHolderSecondActivity extends RecyclerView.ViewHolder {
    private TextView tvGetWeatherStatusName;
    private TextView tvMin_temp;
    private TextView tvMax_temp;
    private ImageView imGetWeatherStatusIcon;
    private TextView tvWindState;
    private TextView tvDate;
    private TextView tvWindSpeed;
    private TextView tvAirPressure;
    private TextView tvWindDirection;



    public ApiViewHolderSecondActivity(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        tvGetWeatherStatusName=itemView.findViewById(R.id.tvGetWeatherStatusName);
        tvMin_temp=itemView.findViewById(R.id.tvMin_temp);
        tvMax_temp=itemView.findViewById(R.id.tvMax_temp);
        tvWindSpeed=itemView.findViewById(R.id.tvWindSpeed);
        tvDate=itemView.findViewById(R.id.tvDate);
        tvWindState=itemView.findViewById(R.id.tvWindState);
        tvWindDirection=itemView.findViewById(R.id.tvWindDirection);
        tvAirPressure=itemView.findViewById(R.id.tvAirPressure);
        imGetWeatherStatusIcon=itemView.findViewById(R.id.imGetWeatherStatusImage);



    }

    public void setData(ResponseModelSecondActivity responseModelSecondActivity) {
        tvGetWeatherStatusName.setText(responseModelSecondActivity.getWeatherStateName());
        tvMin_temp.setText("Minimum_temp: "+Double.toString(responseModelSecondActivity.getMinTemp()));
        tvMax_temp.setText("Maximum_temp: "+Double.toString(responseModelSecondActivity.getMaxTemp()));
        Picasso.get().load("https://www.metaweather.com/static/img/weather/png/"+responseModelSecondActivity.getWeatherStateAbbr()+".png").into(imGetWeatherStatusIcon);
        tvDate.setText("Date: "+responseModelSecondActivity.getApplicableDate());
        tvAirPressure.setText("Air_pressure: "+Float.toString(responseModelSecondActivity.getAirPressure()));
        tvWindSpeed.setText("Wind_speed: "+responseModelSecondActivity.getWindSpeed());
        tvWindDirection.setText("Wind_direction: "+responseModelSecondActivity.getWindDirectionCompass());



//        tvMin_temp.setText((int) responseModelSecondActivity.getMinTemp());
//        tvMin_temp.setText((Integer) responseModelSecondActivity.getMinTemp());

//https://www.metaweather.com/static/img/weather/png/hr.png
    }
}
