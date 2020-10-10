package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApiAdapter  extends RecyclerView.Adapter<ApiViewHolder> {
    private  List<ResponseDryRun> listOfResponseModel;
    private ApiViewHolder.onItemClickedListener onItemClickedListener;


    public ApiAdapter(List<ResponseDryRun> model, ApiViewHolder.onItemClickedListener onItemClickedListener){
        listOfResponseModel=model;
        this.onItemClickedListener=onItemClickedListener;

    }

    @NonNull
    @Override
    public ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_items,parent,false);
        return new ApiViewHolder(view,onItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiViewHolder holder, int position) {
        ResponseDryRun model=listOfResponseModel.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return listOfResponseModel.size();
    }
    public void updateList(List<ResponseDryRun> list){
        listOfResponseModel=list;
        notifyDataSetChanged();
    }


}
