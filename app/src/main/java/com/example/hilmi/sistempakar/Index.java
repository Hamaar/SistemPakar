package com.example.hilmi.sistempakar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hilmi.sistempakar.form.FormDiagnosa;
import com.example.hilmi.sistempakar.form.FormGejala;
import com.example.hilmi.sistempakar.form.FormPenyakit;
import com.example.hilmi.sistempakar.form.FormTentangLovebird;
import com.example.hilmi.sistempakar.galeri.Galeri;
import com.example.hilmi.sistempakar.login.Login;
import com.example.hilmi.sistempakar.tentang.Tentang;

import de.hdodenhof.circleimageview.CircleImageView;

public class Index extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tvWelcome = (TextView)findViewById(R.id.welcome);
        CircleImageView imgLogo = (CircleImageView) findViewById(R.id.imageViewLogo);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.login) {
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tentang) {
            Intent i = new Intent(getApplicationContext(), Tentang.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle diagnosa
            Intent i = new Intent(getApplicationContext(), Index.class);
            startActivity(i);

        }

        if (id == R.id.nav_1) {
            // Handle diagnosa
            Intent i = new Intent(getApplicationContext(), FormDiagnosa.class);
            startActivity(i);

        } else if (id == R.id.nav_2) {
            //handle daftar gejala
            tvWelcome.setVisibility(View.GONE);
            FragmentManager fm2 = getSupportFragmentManager();
            fm2.beginTransaction().replace(R.id.content_home, new FormGejala()).addToBackStack("").commit();

        } else if (id == R.id.nav_3) {
            //handle daftar penyakit
            tvWelcome.setVisibility(View.GONE);
            FragmentManager fm3 = getSupportFragmentManager();
            fm3.beginTransaction().replace(R.id.content_home, new FormPenyakit()).addToBackStack("").commit();

        } else if (id == R.id.nav_4) {
            //handle galeri
            tvWelcome.setVisibility(View.GONE);
            FragmentManager fmGaleri = getSupportFragmentManager();
            fmGaleri.beginTransaction().replace(R.id.content_home, new Galeri()).commit();

        }else if(id == R.id.nav_about_lb){
            //handle
            tvWelcome.setVisibility(View.GONE);
            FragmentManager fmLovebird = getSupportFragmentManager();
            fmLovebird.beginTransaction().replace(R.id.content_home, new FormTentangLovebird()).commit();


         //handle exit
        } else if (id == R.id.nav_5) {
            //handle keluar
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title dialog
            alertDialogBuilder.setTitle("Keluar dari aplikasi?");

            // set pesan dari dialog
            alertDialogBuilder
                    .setMessage("Klik Ya untuk Keluar")
                    .setCancelable(false)
                    .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // jika tombol diklik, maka akan menutup activity ini
                            finish();
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



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
