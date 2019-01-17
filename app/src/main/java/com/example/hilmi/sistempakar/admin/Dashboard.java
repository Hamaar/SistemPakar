package com.example.hilmi.sistempakar.admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hilmi.sistempakar.Index;
import com.example.hilmi.sistempakar.R;

public class Dashboard extends AppCompatActivity {

    Button ivExit;
    BottomNavigationView bnv;

    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);




        ivExit  = (Button)findViewById(R.id.imgExit);
        bnv     = (BottomNavigationView) findViewById(R.id.nav_dasboard);


        FragmentManager fmGejala =getSupportFragmentManager();
        fmGejala.beginTransaction().replace(R.id.content_dashboard, new DashboardGejala()).commit();



        ivExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });





        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_dasboard_1:
                        FragmentManager fmGejala =getSupportFragmentManager();
                        fmGejala.beginTransaction().replace(R.id.content_dashboard, new DashboardGejala()).commit();
                        return true;

                    case R.id.nav_dasboard_2:
                        FragmentManager fmPenyakit = getSupportFragmentManager();
                        fmPenyakit.beginTransaction().replace(R.id.content_dashboard, new DashboardPenyakit()).commit();
                        return true;

                    case R.id.nav_solusi:
                        FragmentManager fmSolusi = getSupportFragmentManager();
                        fmSolusi.beginTransaction().replace(R.id.content_dashboard, new DashboardSolusi()).commit();
                        return true;

                    case R.id.nav_dasboard_3:
                        FragmentManager fmKeputusan = getSupportFragmentManager();
                        fmKeputusan.beginTransaction().replace(R.id.content_dashboard, new DashboardPenyakit()).commit();
                        return true;

                }
                return false;
            }
        });


    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Keluar dari aplikasi?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar!")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        Intent i = new Intent(getApplicationContext(), Index.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

}
