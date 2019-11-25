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
import com.example.trctravelbeta.DetailPenjemputan;
import com.example.trctravelbeta.R;
import com.example.trctravelbeta.model_pesanan.pDatum;

import java.util.List;

public class PesananAdapter extends RecyclerView.Adapter<PesananAdapter.ViewHolder> {

    private List<pDatum> datum;
    private Context context;

    public PesananAdapter (Context context, List<pDatum> datum_data) {
        this.context = context;
        this.datum = datum_data;
    }

    @NonNull
    @Override
    public PesananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.part_list_checkout, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPenjemputan.class);
                context.startActivity(intent);
            }
        });
        return new PesananAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tujuan.setText(datum.get(i).getJadwal().getOrigin());
        viewHolder.detail_tujuan.setText(datum.get(i).getDetailTujuan());
        viewHolder.jumlah_kursi.setText(""+datum.get(i).getJumlahKursi());
        viewHolder.tgl.setText(datum.get(i).getJadwal().getTanggalBerangkat());
        viewHolder.jam.setText(datum.get(i).getJadwal().getJamBerangkat());
    }

    @Override
    public int getItemCount() {
        return datum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tujuan, detail_tujuan, jumlah_kursi, tgl,jam;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tujuan=(TextView) itemView.findViewById(R.id.tujuan);
            detail_tujuan=(TextView) itemView.findViewById(R.id.detail_tujuan);
            jumlah_kursi=(TextView) itemView.findViewById(R.id.kursi_dipesan);
            tgl=(TextView) itemView.findViewById(R.id.tanggal_jemput);
            jam=(TextView) itemView.findViewById(R.id.jam_jemput);
        }
    }
}
