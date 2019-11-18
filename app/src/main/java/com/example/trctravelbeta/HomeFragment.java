package com.example.trctravelbeta;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


import java.text.DateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    public HomeFragment() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnLanjut = (Button) rootView.findViewById(R.id.lanjut);
        final DatePickerDialog.OnDateSetListener onDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                TextView tvDate = (TextView) getActivity().findViewById(R.id.pilih_tanggal);
                tvDate.setText("Tanggal" + " " + String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear)
                        + "-" + String.valueOf(year));
            }
        };
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutPesan();
            }
        });
        final TextView pickDate = (TextView) rootView.findViewById(R.id.pilih_tanggal);
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment().newInstance();
                ((DatePickerFragment) datePicker).setCallBack(onDate);
                datePicker.show(getFragmentManager().beginTransaction(),"Date Picker");
            }
        });
        final TimePickerDialog.OnTimeSetListener onTime =  new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                TextView tvTime = (TextView) getActivity().findViewById(R.id.pilih_jam);
                tvTime.setText("Pukul" + " " + String.valueOf(hourOfDay) + " " + ":" + " " + String.valueOf(minute) + " " + "WIB");
            }
        };
        final TextView pickTime = (TextView) rootView.findViewById(R.id.pilih_jam);
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment().newInstances();
                ((TimePickerFragment) timePicker).setCallBacks(onTime);
                timePicker.show(getFragmentManager().beginTransaction(),"Time Picker");
            }
        });

        return rootView;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) view.findViewById(R.id.pilih_tanggal);
        textView.setText(currentDateString);
    }
    public void lanjutPesan() {
        Intent intent = new Intent(getActivity(), PilihMobil.class);
        startActivity(intent);
    }


}
