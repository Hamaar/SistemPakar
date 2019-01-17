package com.example.hilmi.sistempakar.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hilmi.sistempakar.Index;
import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.helpers.SQLiteHelper;
import com.example.hilmi.sistempakar.models.Gejala;
import com.example.hilmi.sistempakar.models.Keputusan;
import com.example.hilmi.sistempakar.models.Penyakit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FormHasilDiagnosa extends AppCompatActivity {

    private String[] results;
    private HashMap<String, ArrayList<String>> chains = new HashMap<>();
    private TextView txtNamaHama, txtDescHama;
    private ArrayList<Gejala> receivedItemsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_hasil_diagnosa);

        Button btnPeriksaUlang = (Button)findViewById(R.id.btnPeriksaUlang);
        Button btnSelesai = (Button)findViewById(R.id.btnSelesai);


        //klik
        btnPeriksaUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i = new Intent(getApplicationContext(), FormDiagnosa.class);
                startActivity(i);
            }
        });

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Index.class);
                startActivity(i);
            }
        });


        setupView();

        Intent i = getIntent();
        receivedItemsList = (ArrayList<Gejala>) i.getSerializableExtra("ITEMS");
        Log.e("Print Items Count", receivedItemsList.size() + "");
        for (Gejala item :
                receivedItemsList) {
            Log.e("Print Item name: ", item.getGejala() + "");

        }

        results = new String[receivedItemsList.size()];

        // getBundle();
        chainProcess();
      // setupData();
    }






    private void setupView() {
        txtNamaHama = (TextView) findViewById(R.id.txtNamaHama);
        txtDescHama = (TextView) findViewById(R.id.txtDescHama);

        getSupportActionBar().setTitle("Hasil Diagnosa Gejala");
    }



    private void chainProcess() {

        for (String code : results) {
            for (Keputusan keputusan : SQLiteHelper.getInstance(this).getAllKeputusan()) {
                if (keputusan.getGid().contains(code + ",")) {
                    if (chains.containsKey(keputusan.getPid())) {
                        chains.get(keputusan.getPid()).add(code);
                    } else {
                        ArrayList<String> str = new ArrayList<>();
                        str.add(keputusan.getGid().split(",").length + "");
                        str.add(code);
                        chains.put(keputusan.getPid(), str);

                    }
                }
            }
        }
    }





    private void setupData() {
        Set<String> keySet = chains.keySet();
        float top = -1;
        String keyset = "";
        for (String key : keySet) {
            float ms = Float.parseFloat(chains.get(key).get(0));
            float ma = chains.get(key).size() - 1;


            float current = ma / ms;
            if (current >= top) {
                top = current;
                keyset = key;
            }
        }

        Penyakit hama = SQLiteHelper.getInstance(this).getHama(keyset);

        txtNamaHama.setText(hama.getNama());
        txtDescHama.setText(hama.getCara());
    }
}
