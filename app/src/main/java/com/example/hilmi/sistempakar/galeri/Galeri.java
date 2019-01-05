package com.example.hilmi.sistempakar.galeri;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hilmi.sistempakar.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Galeri extends Fragment {



    public Galeri() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_galeri, container, false);



        return rootView;
    }

}
