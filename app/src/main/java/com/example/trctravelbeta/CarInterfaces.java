package com.example.trctravelbeta;

import com.example.trctravelbeta.model_car.mMessage;
import com.example.trctravelbeta.model_customer.CustParent;
import com.example.trctravelbeta.model_customer.CustParent2;
import com.example.trctravelbeta.model_customer.Customer;
import com.example.trctravelbeta.model_driver.model_pesanan.dExample;
import com.example.trctravelbeta.model_login.ResponLogin;
import com.example.trctravelbeta.model_pesanan.pExample;
import com.example.trctravelbeta.model_post_booking.pInduk;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CarInterfaces {
    @GET("v1/jadwal")
    Call<mMessage> getData();

    @GET("v1/pesanan/{id}")
    Call<pExample> getPesan(@Path("id")int id);

    @GET("v1/pesanan/10")
    Call<dExample> getOrder();

    @FormUrlEncoded
    @POST("v1/pesanan/")
    Call<pInduk> getBooking(
            @Field("CustomerId") int CustomerId,
            @Field("JadwalId") int JadwalId,
            @Field("titik_jemput") String titikJemput,
            @Field("jumlah_kursi") int jumlahKursi,
            @Field("total_bayar") int totalBayar,
            @Field("no_telp") String NoHp,
            @Field("detail_tujuan") String detailTujuan,
            @Field("metode_pembayaran") String metodeBayar


    );
    @FormUrlEncoded
    @POST("v1/customer/")
    Call<CustParent> getDaftar(
            @Field("username") String Username,
            @Field("password") String Password,
            @Field("nama") String Nama,
            @Field("no_telp") String NoHp
    );

    @FormUrlEncoded
    @POST("v1/customer/signin")
    Call<ResponLogin> getMsuk(
            @Field("username") String Username,
            @Field("password") String Password
    );
}

