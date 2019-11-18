package com.example.trctravelbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class PilihMobil extends AppCompatActivity {

    RecyclerView mobilRecycler;
    MobilAdapter mobilAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_mobil);

        mobilRecycler = findViewById(R.id.pilih_mobil);
        mobilRecycler.setLayoutManager(new LinearLayoutManager(this));

        mobilAdapter = new MobilAdapter(this, getMyList());
        mobilRecycler.setAdapter(mobilAdapter);

    }

    private ArrayList<MobilModel> getMyList() {
        ArrayList<MobilModel> mobilModels = new ArrayList<>();

        MobilModel m = new MobilModel();
        m.setMerk("New Avanza");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Jazz");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Brio");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Jazz");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Brio");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Jazz");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Brio");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Jazz");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);

        m = new MobilModel();
        m.setMerk("New Honda Brio");
        m.setPlat("BE232");
        m.setKursi("7 Kursi");
        m.setStatus("Tersedia");
        m.setGambarMobil(R.drawable.mobil);
        mobilModels.add(m);


        return mobilModels;
    }


}
