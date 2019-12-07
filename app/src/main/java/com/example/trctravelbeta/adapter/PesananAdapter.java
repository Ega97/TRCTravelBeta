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


import com.example.trctravelbeta.DetailPenjemputan;
import com.example.trctravelbeta.R;
import com.example.trctravelbeta.model_pesanan.pDatum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        return new PesananAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesananAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.tujuan.setText(datum.get(i).getJadwal().getOrigin());
        viewHolder.detail_tujuan.setText(datum.get(i).getDetailTujuan());
        viewHolder.jumlah_kursi.setText(""+datum.get(i).getJumlahKursi());
        viewHolder.tgl.setText(datum.get(i).getJadwal().getTanggalBerangkat());
        viewHolder.jam.setText(datum.get(i).getJadwal().getJamBerangkat());
        viewHolder.checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPenjemputan.class);
                intent.putExtra("merekmobil", datum.get(i).getJadwal().getCar().getJenisMobil());
                intent.putExtra("plat", datum.get(i).getJadwal().getCar().getNoPlat());
                intent.putExtra("kursi", datum.get(i).getJumlahKursi());
                intent.putExtra("origin", datum.get(i).getJadwal().getOrigin());
                intent.putExtra("detail_tujuan", datum.get(i).getDetailTujuan());
                intent.putExtra("nama", datum.get(i).getCustomer().getNama());
                intent.putExtra("no_hp", datum.get(i).getCustomer().getNoTelp());
                intent.putExtra("tgl", datum.get(i).getJadwal().getTanggalBerangkat());
                intent.putExtra("jam", datum.get(i).getJadwal().getJamBerangkat());
                intent.putExtra("jmpt", datum.get(i).getTitikJemput());
                intent.putExtra("harga", datum.get(i).getTotalBayar());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datum.size();
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
