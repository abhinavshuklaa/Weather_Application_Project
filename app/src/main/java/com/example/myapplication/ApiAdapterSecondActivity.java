package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApiAdapterSecondActivity extends RecyclerView.Adapter<ApiViewHolderSecondActivity> {
    private List<ResponseModelSecondActivity> responseModelSecondActivityList;

    public ApiAdapterSecondActivity(List<ResponseModelSecondActivity> modelSecondActivities) {
        responseModelSecondActivityList = modelSecondActivities;
    }


    @NonNull
    @Override
    public ApiViewHolderSecondActivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_activity_recycler_view_items, parent, false);
        return new ApiViewHolderSecondActivity(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolderSecondActivity holder, int position) {
        ResponseModelSecondActivity responseModelSecondActivity = responseModelSecondActivityList.get(position);
        holder.setData(responseModelSecondActivity);
    }

    @Override
    public int getItemCount() {
        return responseModelSecondActivityList.size();
    }

    public void updateListSecondActivity(List<ResponseModelSecondActivity> list) {
        responseModelSecondActivityList = list;
        notifyDataSetChanged();
    }
}
