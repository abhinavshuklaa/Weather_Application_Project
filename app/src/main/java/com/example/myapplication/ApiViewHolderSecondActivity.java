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



    public ApiViewHolderSecondActivity(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        tvGetWeatherStatusName=itemView.findViewById(R.id.tvGetWeatherStatusName);
        tvMin_temp=itemView.findViewById(R.id.tvMin_temp);
        tvMax_temp=itemView.findViewById(R.id.tvMax_temp);
        imGetWeatherStatusIcon=itemView.findViewById(R.id.imGetWeatherStatusImage);


    }

    public void setData(ResponseModelSecondActivity responseModelSecondActivity) {
        tvGetWeatherStatusName.setText(responseModelSecondActivity.getWeatherStateName());
        tvMin_temp.setText(Double.toString(responseModelSecondActivity.getMinTemp()));
        tvMax_temp.setText(Double.toString(responseModelSecondActivity.getMaxTemp()));
        Picasso.get().load("https://www.metaweather.com/static/img/weather/png/"+responseModelSecondActivity.getWeatherStateAbbr()+".png").into(imGetWeatherStatusIcon);



//        tvMin_temp.setText((int) responseModelSecondActivity.getMinTemp());
//        tvMin_temp.setText((Integer) responseModelSecondActivity.getMinTemp());

//https://www.metaweather.com/static/img/weather/png/hr.png
    }
}
