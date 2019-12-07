package com.example.trctravelbeta.driver;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.trctravelbeta.Login;
import com.example.trctravelbeta.LoginDriver;
import com.example.trctravelbeta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilDriverFragment extends Fragment {


    private Button logouts;

    public ProfilDriverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this f ragment
        View rootView = inflater.inflate(R.layout.fragment_profil_driver, container, false);
        logouts =  rootView.findViewById(R.id.logout_driver);
        logouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), LoginDriver.class);
                startActivity(i);
            }
        });

        return rootView;
    }

}
