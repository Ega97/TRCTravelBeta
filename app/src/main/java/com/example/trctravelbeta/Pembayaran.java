package com.example.trctravelbeta;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import retrofit2.http.Url;

public class Pembayaran extends AppCompatActivity {
    private Button pilih;
    private ImageView img;
    private static final int PICK_IMAGE = 100;
    Uri imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        pilih = findViewById(R.id.pilih_berkas);
        img = findViewById(R.id.image_bukti);
        pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalery();
            }
        });
        Button konfir = (Button) findViewById(R.id.konfir_btn);
        konfir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pembayaran.this, Konfirmasi.class);
                startActivity(i);
            }
        });
    }

    private void openGalery() {
        Intent galery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUrl = data.getData();
            img.setImageURI(imageUrl);
        }
    }
}
