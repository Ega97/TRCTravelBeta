package com.example.trctravelbeta;


import android.app.TimePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    TimePickerDialog.OnTimeSetListener onTimeSet;
    private boolean isModals = false;

    public static TimePickerFragment newInstances()
    {
        TimePickerFragment frag = new TimePickerFragment();
        frag.isModals = true; // WHEN FRAGMENT IS CALLED AS A DIALOG SET FLAG
        return frag;
    }

    public TimePickerFragment(){}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker

        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        // Create a new instance of DatePickerDialog and return it
        return new TimePickerDialog(getActivity(), onTimeSet,hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(isModals) // AVOID REQUEST FEATURE CRASH
        {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        else {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }
    }

    public void setCallBacks(TimePickerDialog.OnTimeSetListener onTimes) {
        onTimeSet = onTimes;
    }

}
