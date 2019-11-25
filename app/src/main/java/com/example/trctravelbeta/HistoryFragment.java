package com.example.trctravelbeta;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.trctravelbeta.adapter.JadwalAdapter;
import com.example.trctravelbeta.adapter.PesananAdapter;
import com.example.trctravelbeta.model_pesanan.pDatum;
import com.example.trctravelbeta.model_pesanan.pExample;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private ProgressBar load;
    private PesananAdapter pesananAdapter;
    private RecyclerView recyclerView;
    private Context context;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);
        load = (ProgressBar) rootView.findViewById(R.id.progressBar);
        recyclerView = rootView.findViewById(R.id.list_booking);
        recyclerView.setVisibility(View.GONE);
        load.setVisibility(View.VISIBLE);
        final FragmentActivity c = getActivity();
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        getPesanResponse();
        return rootView;
    }

    private void getPesanResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.135:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CarInterfaces requestInterface = retrofit.create(CarInterfaces.class);
        Call<pExample> exampleCall= requestInterface.getPesan();
        exampleCall.enqueue(new Callback<pExample>() {
            @Override
            public void onResponse(Call<pExample> call, Response<pExample> responses) {
                if (responses.isSuccessful()) {
                    List<pDatum> datax = responses.body().getData();
                    pesananAdapter = new PesananAdapter(getActivity().getApplicationContext(), datax);
                    load.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(pesananAdapter);
                    pesananAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<pExample> call, Throwable t) {

            }
        });
    }

}
