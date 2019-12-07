package com.example.trctravelbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ActTai extends AppCompatActivity {

    private EditText a;

    public ActTai(EditText a) {
        this.a = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tai);
    }
}
