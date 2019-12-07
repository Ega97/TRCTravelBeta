package com.example.trctravelbeta.driver;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.trctravelbeta.CarInterfaces;
import com.example.trctravelbeta.R;
import com.example.trctravelbeta.SharedPrefManager;
import com.example.trctravelbeta.adapter.DriverAdapter;
import com.example.trctravelbeta.adapter.PesananAdapter;
import com.example.trctravelbeta.model_driver.model_pesanan.dDatum;
import com.example.trctravelbeta.model_driver.model_pesanan.dExample;
import com.example.trctravelbeta.model_pesanan.pDatum;
import com.example.trctravelbeta.model_pesanan.pExample;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {


    public OrderFragment() {
        // Required empty public constructor
    }

    private ProgressBar load;
    private DriverAdapter driverAdapter;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_order, container, false);
        load = rootView.findViewById(R.id.progressBar);
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
        Call<dExample> exampleCall= requestInterface.getOrder();
        exampleCall.enqueue(new Callback<dExample>() {
            @Override
            public void onResponse(Call<dExample> call, Response<dExample> responses) {
                if (responses.isSuccessful()) {
                    List<dDatum> ord = responses.body().getOrders();
                    driverAdapter = new DriverAdapter(ord, getActivity().getApplicationContext());
                    load.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(driverAdapter);
                    driverAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<dExample> call, Throwable t) {

            }
        });
    }

}
