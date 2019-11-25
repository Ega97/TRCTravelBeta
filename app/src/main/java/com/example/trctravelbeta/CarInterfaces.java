package com.example.trctravelbeta;

import com.example.trctravelbeta.model_car.mMessage;
import com.example.trctravelbeta.model_pesanan.pExample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CarInterfaces {
    @GET("v1/jadwal")
    Call<mMessage> getData();

    @GET("v1/pesanan/1")
    Call<pExample> getPesan();
}
