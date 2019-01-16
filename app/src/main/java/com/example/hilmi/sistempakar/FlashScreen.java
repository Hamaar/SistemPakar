package com.example.hilmi.sistempakar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FlashScreen extends AppCompatActivity {

    private int waktu_flash = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_screen);

        //handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(FlashScreen.this, Index.class);
                startActivity(home);
                finish();

            }
        },

                waktu_flash);

    }
}