package com.example.hilmi.sistempakar.admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hilmi.sistempakar.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardKeputusan extends Fragment {


    public DashboardKeputusan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_dashboard_keputusan, container, false);


        return rootView;
    }

}
