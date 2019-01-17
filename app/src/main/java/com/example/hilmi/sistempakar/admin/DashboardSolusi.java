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
public class DashboardSolusi extends Fragment {


    public DashboardSolusi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_solusi, container, false);
    }

}
