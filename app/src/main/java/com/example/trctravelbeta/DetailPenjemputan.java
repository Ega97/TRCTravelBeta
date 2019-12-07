package com.example.trctravelbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DetailPenjemputan extends AppCompatActivity {
    private String mMerk, mPlat, mOrigin, mDetailTujuan, mJam, mJemput, mNama,mTelp, mTgl;
    private int mKursi, mHarga;
    TextView merk, plat, origin, detailtujuan, tgl, jam, jemput, kursi, harga, nama, telp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penjemputan);
        Button bayar = (Button) findViewById(R.id.bayar);

        initView();

        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPenjemputan.this, Pembayaran.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {

        Locale locale = new Locale("in","ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        Intent intent = getIntent();
        merk = findViewById(R.id.merk_mobil);
        plat = findViewById(R.id.plat_mobil);
        kursi = findViewById(R.id.kursi_booking);
        origin = findViewById(R.id.origin);
        detailtujuan = findViewById(R.id.detail_tujuan);
        tgl = findViewById(R.id.tanggal_keberangkatan);
        jam = findViewById(R.id.jam);
        jemput = findViewById(R.id.penjemputan);
        harga = findViewById(R.id.jumlah_harga);
        nama = findViewById(R.id.nama);
        telp = findViewById(R.id.telp);

        mMerk = getIntent().getStringExtra("merekmobil");
        mPlat = getIntent().getStringExtra("plat");
        mKursi = getIntent().getIntExtra("kursi", 0);
        mOrigin = getIntent().getStringExtra("origin");
        mDetailTujuan = getIntent().getStringExtra("detail_tujuan");
        mTgl = getIntent().getStringExtra("tgl");
        mJam = getIntent().getStringExtra("jam");
        mJemput = getIntent().getStringExtra("jmpt");
        mHarga = getIntent().getIntExtra("harga",0);
        mNama = getIntent().getStringExtra("nama");
        mTelp = getIntent().getStringExtra("no_hp");

        merk.setText(mMerk);
        plat.setText(mPlat);
        kursi.setText((mKursi)+" "+"Kursi");
        origin.setText(mOrigin);
        detailtujuan.setText(mDetailTujuan);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        tgl.setText(sdf.format(mTgl));
        jam.setText(mJam);
        jemput.setText(mJemput);
        harga.setText(format.format(mHarga));
        nama.setText(mNama);
        telp.setText(mTelp);
//
//        Locale locale = new Locale("in", "ID");
//        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
//        totals = getIntent().getIntExtra("harga",0);
//        iTotalbayar.setText(format.format(totals));


    }
}
