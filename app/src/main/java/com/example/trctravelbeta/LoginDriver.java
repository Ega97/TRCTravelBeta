package com.example.trctravelbeta;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trctravelbeta.driver.MainDriver;
import com.example.trctravelbeta.model_login.ResponLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginDriver extends AppCompatActivity {
    private Button masuk;
    SharedPrefManager sharedPrefManager;

    private EditText Eusername, Epassword;
    String Susername, Spassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_driver);
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        Eusername = findViewById(R.id.username_driver);
        Epassword = findViewById(R.id.password_driver);
        masuk =  findViewById(R.id.signin_driver);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Susername = Eusername.getText().toString();
                Spassword = Epassword.getText().toString();

                LoginD(Susername, Spassword);
            }
        });
    }

    private void LoginD(String susername, String spassword) {
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.43.135:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CarInterfaces requestInterface = retrofit.create(CarInterfaces.class);
            Call<ResponLogin> custParentCall = requestInterface.getMsuk(susername,spassword);
            custParentCall.enqueue(new Callback<ResponLogin>() {
                @Override
                public void onResponse(Call<ResponLogin> call, Response<ResponLogin> response) {
                    if (response.isSuccessful()) {
                        int id = response.body().getData().getUser().getId();
                        sharedPrefManager.saveSPInt(String.valueOf(sharedPrefManager.ID), id);
                        sharedPrefManager.saveSPBoolean(sharedPrefManager.IS_LOGIN,true);
                        Log.d("TAG", "onResponse: "+response.body().getData().getUser().getId());
                        startActivity(new Intent(LoginDriver.this,MainDriver.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                        finish();

                    }
                }

                @Override
                public void onFailure(Call<ResponLogin> call, Throwable t) {
                    Toast.makeText(LoginDriver.this, "Gagal Masuk cek koneksi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finishAffinity();
                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();


    }
}
