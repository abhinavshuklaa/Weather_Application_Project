package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ApiViewHolder.onItemClickedListener{
    private EditText etEnterId;
    private ImageView btnGetApi;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ApiAdapter apiAdapter;
    private List<ResponseDryRun> modelList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {
        apiAdapter=new ApiAdapter(modelList,this);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(apiAdapter);

    }

    private void initViews() {
        etEnterId=findViewById(R.id.etEnterId);
        btnGetApi=findViewById(R.id.btnRequestApi);
        recyclerView=findViewById(R.id.recyclerView);
//        progressBar=findViewById(R.id.progressBar);
//        progressBar.setVisibility(View.GONE);



        btnGetApi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ApiClient apiClient=Network.getRetrofitInstance(MainActivity.this).create(ApiClient.class);

                Call<List<ResponseDryRun>> call=apiClient.enterName(etEnterId.getText().toString());
                call.enqueue(new Callback<List<ResponseDryRun>>() {
                    @Override
                    public void onResponse(Call<List<ResponseDryRun>> call, Response<List<ResponseDryRun>> response) {
                        if(response.code()== HttpURLConnection.HTTP_OK && response.body() != null) {
                            modelList = response.body();
                            apiAdapter.updateList(modelList);


                        }


                    }

                    @Override
                    public void onFailure(Call<List<ResponseDryRun>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Response Failed" + t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }


    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, "Item Clicked at position"+ position, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,Weather_Page_Activity.class);
//            intent.putExtra("val",modelList.get(position).getWoeid());
            intent.putExtra("data",modelList.get(position).getWoeid());
//       intent.putExtra("woeid",2487956);
        startActivity(intent);

    }
}