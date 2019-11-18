package com.example.trctravelbeta;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MobilHolder extends RecyclerView.ViewHolder {

    ImageView gambarMobil;
    TextView tMerk, tPlat, tKursi, tStatus;


    public MobilHolder(@NonNull View itemView) {
        super(itemView);
        this.gambarMobil = itemView.findViewById(R.id.gambar_mobil);
        this.tMerk = itemView.findViewById(R.id.merk_mobil);
        this.tPlat = itemView.findViewById(R.id.plat_mobil);
        this.tKursi = itemView.findViewById(R.id.kursi_tersedia);
        this.tStatus = itemView.findViewById(R.id.status);

    }
}
