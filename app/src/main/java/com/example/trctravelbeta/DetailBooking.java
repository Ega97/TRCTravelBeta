package com.example.trctravelbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailBooking extends AppCompatActivity {

    private TextView counterTxt;
    private Button minusBtn;
    private Button plusBtn;
    private Button resetBtn;
    private int counter;
    private Button bookingSekarang;

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
        counterTxt = (TextView) findViewById(R.id.kursi_count);
        plusBtn = (Button) findViewById(R.id.tambah_kursi);
        plusBtn.setOnClickListener(onClickListener);
        resetBtn = (Button) findViewById(R.id.reset_kursi);
        resetBtn.setOnClickListener(onClickListener);
        bookingSekarang = (Button) findViewById(R.id.booking_sekarang);
        bookingSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBooking.this, MainActivity.class);
                startActivity(intent);
            }
        });

        initCounter();

    }

    private void initCounter() {
        counter = 0;
        counterTxt.setText(counter + "");
    }

    private void plusCounter() {
        counter++;
        counterTxt.setText(counter + "");
    }
}
