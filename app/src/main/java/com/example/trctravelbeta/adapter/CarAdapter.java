package com.example.trctravelbeta.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trctravelbeta.DetailBooking;
import com.example.trctravelbeta.R;
import com.example.trctravelbeta.model_car.mJadwal;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private List<mJadwal> datum;
    private Context context;

    public CarAdapter (Context context, List<mJadwal> datum_data) {
        this.context=context;
        this.datum = datum_data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_mobil, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailBooking.class);
                context.startActivity(intent);
            }
        });
        return new CarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.merk.setText(datum.get(i).getCar().getJenisMobil());
        viewHolder.plat.setText(datum.get(i).getCar().getNoPlat());
        viewHolder.kursi.setText(""+datum.get(i).getJumlahKursi()+" "+"Kursi Tersedia");
        viewHolder.status.setText(datum.get(i).getStatus());
        viewHolder.tgl.setText(datum.get(i).getTanggalBerangkat());
        viewHolder.jam.setText(datum.get(i).getJamBerangkat()+ " ");
    }

    @Override
    public int getItemCount() {
        return datum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView merk,plat,kursi,status,tgl,jam ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            merk=(TextView) itemView.findViewById(R.id.merk_mobil);
            plat=(TextView) itemView.findViewById(R.id.plat_mobil);
            kursi=(TextView) itemView.findViewById(R.id.kursi_tersedia);
            status=(TextView) itemView.findViewById(R.id.status);
            tgl=(TextView) itemView.findViewById(R.id.tanggal_brgkt);
            jam=(TextView) itemView.findViewById(R.id.jam_brgkt);

        }
    }
}
