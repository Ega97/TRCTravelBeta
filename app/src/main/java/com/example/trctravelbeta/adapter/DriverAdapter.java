package com.example.trctravelbeta.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trctravelbeta.R;
import com.example.trctravelbeta.model_driver.model_pesanan.dDatum;

import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder> {

    public DriverAdapter(List<dDatum> driver, Context c) {
        this.driver = driver;
        this.c = c;
    }

    private List<dDatum> driver;
    private Context c;

    @NonNull
    @Override
    public DriverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.part_list_checkout, viewGroup, false);
        return new DriverAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tujuan.setText(driver.get(i).getJadwal().getOrigin());
        viewHolder.detail_tujuan.setText(driver.get(i).getDetailTujuan());
        viewHolder.jumlah_kursi.setText(""+driver.get(i).getJumlahKursi());
        viewHolder.tgl.setText(driver.get(i).getJadwal().getTanggalBerangkat());
        viewHolder.jam.setText(driver.get(i).getJadwal().getJamBerangkat());
    }

    @Override
    public int getItemCount() {
        return driver.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView checkout;
        private TextView tujuan, detail_tujuan, jumlah_kursi, tgl,jam;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tujuan=itemView.findViewById(R.id.tujuan);
            detail_tujuan=itemView.findViewById(R.id.detail_tujuan);
            jumlah_kursi=itemView.findViewById(R.id.kursi_dipesan);
            tgl=itemView.findViewById(R.id.tanggal_jemput);
            jam=itemView.findViewById(R.id.jam_jemput);
            checkout= itemView.findViewById(R.id.checkout);
        }
    }
}
