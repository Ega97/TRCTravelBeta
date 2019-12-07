package com.example.trctravelbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trctravelbeta.adapter.JadwalAdapter;
import com.example.trctravelbeta.model_post_booking.pInduk;

import java.text.NumberFormat;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailBooking extends AppCompatActivity {


    private EditText iCustid, iJadwalid, iNohp, iTitikjemput, iDetailtujuan, iMetodebayar;
    private TextView iTotalbayar, iJumlahkursi;
    SharedPrefManager sharedPrefManager;
    private int  totals;
    private Button plusBtn;
    private Button resetBtn;
    private int counter;
    private Button bookingSekarang;
    private JadwalAdapter jadwalAdapter;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tambah_kursi :
                    plusCounter();
                    break;
                case R.id.reset_kursi :
                    initCounter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);

        iNohp = findViewById(R.id.no_hp);
        iTitikjemput =  findViewById(R.id.titik_jemput);
        iDetailtujuan=  findViewById(R.id.detail_tujuan);
        iMetodebayar =  findViewById(R.id.metode_bayar);
        iTotalbayar = findViewById(R.id.total_bayar);
        iJumlahkursi = findViewById(R.id.kursi_count);

        Locale locale = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        totals = getIntent().getIntExtra("harga",0);
        iTotalbayar.setText(format.format(totals));


        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        Intent intent = getIntent();
        plusBtn = findViewById(R.id.tambah_kursi);
        plusBtn.setOnClickListener(onClickListener);
        resetBtn = findViewById(R.id.reset_kursi);
        resetBtn.setOnClickListener(onClickListener);
        bookingSekarang = findViewById(R.id.booking_sekarang);
        bookingSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookingData();
            }
        });

        initCounter();
    }

    private void BookingData() {

        int idcus = sharedPrefManager.getID();
        Log.d("TAG", "BookingData: " +idcus);
        String nohp = iNohp.getText().toString();
        int id = getIntent().getIntExtra("id",0);
        Log.d("TAG", "egaaa " +id);

        String titikjemput = iTitikjemput.getText().toString();
        String detailtujuan = iDetailtujuan.getText().toString();
        String metodebayar = iMetodebayar.getText().toString();
        int total_bayar = totals * counter;
        int jumlahkursi = Integer.parseInt(iJumlahkursi.getText().toString());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.135:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarInterfaces requestInterface = retrofit.create(CarInterfaces.class);
        Call<pInduk> induk = requestInterface.getBooking(idcus, id, titikjemput, jumlahkursi, total_bayar, nohp, detailtujuan, metodebayar);
        induk.enqueue(new Callback<pInduk>() {
            @Override
            public void onResponse(Call<pInduk> call, Response<pInduk> response) {
                Toast.makeText(DetailBooking.this, "Berhasil Booking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<pInduk> call, Throwable t) {
                Toast.makeText(DetailBooking.this, "Berhasil Booking", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DetailBooking.this, MainActivity.class);
                startActivity(i);
            }
        });
    }



    private void initCounter() {
        counter = 0;
        iJumlahkursi.setText(counter + "");
    }

    private void plusCounter() {
        counter++;
        iJumlahkursi.setText(counter + "");
    }
}
