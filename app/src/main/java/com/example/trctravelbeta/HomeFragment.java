package com.example.trctravelbeta;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;


import com.example.trctravelbeta.adapter.CarAdapter;
import com.example.trctravelbeta.adapter.JadwalAdapter;
import com.example.trctravelbeta.model_car.mJadwal;
import com.example.trctravelbeta.model_car.mMessage;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

    private JadwalAdapter jadwalAdapter;
    private RecyclerView recyclerView;
    private Context context;
    public HomeFragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = rootView.findViewById(R.id.list_tanggal);
        final FragmentActivity c = getActivity();
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        getDateResponse();
        return rootView;
    }

    private void getDateResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.135:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CarInterfaces requestInterface = retrofit.create(CarInterfaces.class);
        Call<mMessage> exampleCall= requestInterface.getData();
        exampleCall.enqueue(new Callback<mMessage>() {
            @Override
            public void onResponse(Call<mMessage> call, Response<mMessage> response) {
                if (response.isSuccessful()) {
                    List<mJadwal> datax = response.body().getData();
                    jadwalAdapter = new JadwalAdapter(getActivity().getApplicationContext(), datax);
                    recyclerView.setAdapter(jadwalAdapter);
                    jadwalAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mMessage> call, Throwable t) {

            }
        });
    }
}
