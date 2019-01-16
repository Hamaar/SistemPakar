package com.example.hilmi.sistempakar.galeri;


import android.media.Image;
import android.os.Bundle;
import android.support.transition.Visibility;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hilmi.sistempakar.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Galeri extends Fragment {

    ImageView Allimg;
    int [] imgGaleri = {R.drawable.img_snot, R.drawable.img_eggbinding, R.drawable.img_nyilet};
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    public Galeri() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_galeri, container, false);


        Allimg = (ImageView)rootView.findViewById(R.id.ivGaleri);

        btn1 = (Button)rootView.findViewById(R.id.btn_img1);
        btn2 = (Button)rootView.findViewById(R.id.btn_img2);
        btn3 = (Button)rootView.findViewById(R.id.btn_img3);
        btn4 = (Button)rootView.findViewById(R.id.btn_img4);
        btn5 = (Button)rootView.findViewById(R.id.btn_img5);
        btn6 = (Button)rootView.findViewById(R.id.btn_img6);
        btn7 = (Button)rootView.findViewById(R.id.btn_img7);


        //klik
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allimg.setImageDrawable(getResources().getDrawable(R.drawable.img_snot));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allimg.setImageDrawable(getResources().getDrawable(R.drawable.img_eggbinding));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allimg.setImageDrawable(getResources().getDrawable(R.drawable.img_eggbinding));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allimg.setImageDrawable(getResources().getDrawable(R.drawable.img_nyilet));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allimg.setImageDrawable(getResources().getDrawable(R.drawable.img_ganguanpernafasan));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allimg.setImageDrawable(getResources().getDrawable(R.drawable.img_ganguanpernafasan));
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allimg.setImageDrawable(getResources().getDrawable(R.drawable.img_bubul));
            }
        });




        return rootView;
    }



}
