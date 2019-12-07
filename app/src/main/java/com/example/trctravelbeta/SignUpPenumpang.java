package com.example.trctravelbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trctravelbeta.model_customer.CustParent;
import com.example.trctravelbeta.model_customer.Customer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpPenumpang extends AppCompatActivity {

    private EditText Eusername, Epassword, Enama, Eno_telp;
    private Button daftarr;
    String Susername, Spassword, Snama, Snohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_penumpang);
        Eusername = (EditText) findViewById(R.id.username_daftar);
        Epassword = (EditText) findViewById(R.id.password_daftar);
        Enama = (EditText) findViewById(R.id.nama);
        Eno_telp = (EditText) findViewById(R.id.hp);
        daftarr = (Button) findViewById(R.id.daftar);
        daftarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Susername = Eusername.getText().toString();
                Spassword = Epassword.getText().toString();
                Snama = Enama.getText().toString();
                Snohp = Eno_telp.getText().toString();

                DaftarPenumpang(Susername, Spassword, Snama, Snohp);

            }
        });


    }

    private void DaftarPenumpang(String username, String password, String nama, String no_hp) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.135:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CarInterfaces requestInterface = retrofit.create(CarInterfaces.class);
        Call<CustParent> custParentCall = requestInterface.getDaftar(username, password, nama, no_hp);
        custParentCall.enqueue(new Callback<CustParent>() {
            @Override
            public void onResponse(Call<CustParent> call, Response<CustParent> response) {
                Toast.makeText(SignUpPenumpang.this, "Berhasil Daftar", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SignUpPenumpang.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<CustParent> call, Throwable t) {
                Toast.makeText(SignUpPenumpang.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
