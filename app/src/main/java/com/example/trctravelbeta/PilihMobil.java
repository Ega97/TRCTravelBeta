package com.example.trctravelbeta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.trctravelbeta.adapter.CarAdapter;
import com.example.trctravelbeta.model_car.mJadwal;
import com.example.trctravelbeta.model_car.mMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PilihMobil extends AppCompatActivity {


    private Context context;
    private CarAdapter carAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_mobil);
        recyclerView = findViewById(R.id.pilih_mobil);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        getCarsResponse();

    }

    private void getCarsResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.135:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CarInterfaces requestInterface = retrofit.create(CarInterfaces.class);
        Call<mMessage> exampleCall= requestInterface.getData();
        exampleCall.enqueue(new Callback<mMessage>() {
            @Override
            public void onResponse(Call<mMessage> call, Response<mMessage> response) {
                if (response.isSuccessful()) {
                    List<mJadwal> datax = response.body().getData();
                    carAdapter = new CarAdapter(getApplicationContext(), datax);
                    recyclerView.setAdapter(carAdapter);
                    carAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mMessage> call, Throwable t) {

            }
        });
    }
}

