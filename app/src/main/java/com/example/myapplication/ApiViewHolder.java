package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ApiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView tvName;
    private TextView tvLogin;
    private TextView tvDescription;
    private onItemClickedListener onItemClickedListener;


    public ApiViewHolder(@NonNull View itemView, onItemClickedListener onItemClickedListener) {
        super(itemView);
        this.onItemClickedListener = onItemClickedListener;
        initViews(itemView);

    }

    private void initViews(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        tvLogin = itemView.findViewById(R.id.tvLogin);
        tvDescription = itemView.findViewById(R.id.tvDescription);

        itemView.setOnClickListener(this);

    }

    public void setData(ResponseDryRun responseModel) {

        tvName.setText("City " + responseModel.getTitle());
//        tvDescription.setText("Latitude "+responseModel.getLocationType());
        tvLogin.setText("Latitude " + responseModel.getLattLong());
//        tvName.setText(responseModel.getName());
//        tvLogin.setText(responseModel.getOwner().getLogin());
//        tvDescription.setText(responseModel.getDescription());


    }

    @Override
    public void onClick(View view) {
        onItemClickedListener.onItemClicked(getAdapterPosition());


    }

    public interface onItemClickedListener {
        void onItemClicked(int position);
    }

}
