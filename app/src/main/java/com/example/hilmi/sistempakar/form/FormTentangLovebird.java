package com.example.hilmi.sistempakar.form;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hilmi.sistempakar.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormTentangLovebird extends Fragment {


    public FormTentangLovebird() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tentang_lovebird, container, false);

        TextView tvTentangLb = (TextView)rootView.findViewById(R.id.frmTentangLovebird);

        tvTentangLb.setText("Love Bird Adalah Hewan Peliharaan Yang banyak digemari di kalangan Masyarakat Khusunya bagi Pecinta Burung Lovbird");


        return rootView;

    }

}
