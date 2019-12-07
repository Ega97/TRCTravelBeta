package com.example.trctravelbeta.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trctravelbeta.PilihMobil;
import com.example.trctravelbeta.R;
import com.example.trctravelbeta.model_car.mJadwal;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {

    private List<mJadwal> datum;
    private Context context;

    public JadwalAdapter (Context context, List<mJadwal> datum_data) {
        this.context=context;
        this.datum = datum_data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_tanggal, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PilihMobil.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return new JadwalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tanggal.setText(datum.get(i).getTanggalBerangkat());
        viewHolder.origin.setText(datum.get(i).getOrigin());
        viewHolder.destination.setText(datum.get(i).getDestination());
    }

    @Override
    public int getItemCount() {
        return datum.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tanggal, origin, destination;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tanggal=itemView.findViewById(R.id.tanggal_keberangkatan);
            origin=itemView.findViewById(R.id.origin);
            destination=itemView.findViewById(R.id.destination);
        }
    }
}
