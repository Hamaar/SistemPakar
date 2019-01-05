package com.example.hilmi.sistempakar.admin;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.hilmi.sistempakar.R;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bnv = (BottomNavigationView) findViewById(R.id.nav_dasboard);

        FragmentManager fmGejala =getSupportFragmentManager();
        fmGejala.beginTransaction().replace(R.id.content_dashboard, new DashboardGejala()).commit();


        //klik
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

                }
                return false;
            }
        });


    }
}
