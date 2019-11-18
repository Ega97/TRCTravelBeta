package com.example.trctravelbeta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MobilAdapter extends RecyclerView.Adapter<MobilHolder> {

    Context c;
    ArrayList<MobilModel> mobilmodels; //untuk menampilkan listarray

    public MobilAdapter(Context c, ArrayList<MobilModel> mobilmodels) {
        this.c = c;
        this.mobilmodels = mobilmodels;
    }

    @NonNull
    @Override
    public MobilHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_mobil, null);
        return new MobilHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobilHolder mobilHolder, int i) {
        mobilHolder.tMerk.setText(mobilmodels.get(i).getMerk());
        mobilHolder.tPlat.setText(mobilmodels.get(i).getPlat());
        mobilHolder.tStatus.setText(mobilmodels.get(i).getStatus());
        mobilHolder.tKursi.setText(mobilmodels.get(i).getKursi());
        mobilHolder.gambarMobil.setImageResource(mobilmodels.get(i).getGambarMobil());
    }

    @Override
    public int getItemCount() {
        return mobilmodels.size();
    }
}
