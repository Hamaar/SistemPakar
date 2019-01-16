package com.example.hilmi.sistempakar.admin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.db.DbHelper;
import com.example.hilmi.sistempakar.form.FormGejala;

import org.w3c.dom.Text;

public class TambahData extends AppCompatActivity {

    protected Cursor cursor;
    DbHelper dbhelper;
    DbHelper dbHelperPenyakit;

    EditText edtAddKode, edtAddNama, edtAddPenyebab, edtAddSolusi;
    TextView tvAddKode, tvAddNama, tvAddPenyebab, tvAddSolusi;
    Button btnSimpanData, btnSimpanPenyakit, btnResetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);


        dbhelper = new DbHelper(this);
        dbHelperPenyakit = new DbHelper(this);


        //EditText
        edtAddKode = (EditText) findViewById(R.id.edtAddKode);
        edtAddNama = (EditText) findViewById(R.id.edtAddNama);
        edtAddPenyebab = (EditText) findViewById(R.id.edtAddPenyebab);
        edtAddSolusi = (EditText) findViewById(R.id.edtAddSolusi);

        //TextView
        tvAddKode = (TextView) findViewById(R.id.tvaddKode);
        tvAddNama = (TextView) findViewById(R.id.tvaddNama);
        tvAddPenyebab = (TextView) findViewById(R.id.tvaddPenyebab);
        tvAddSolusi = (TextView) findViewById(R.id.tvaddSolusi);


        edtAddSolusi.setVisibility(View.INVISIBLE);
        tvAddSolusi.setVisibility(View.INVISIBLE);


        btnSimpanData = (Button) findViewById(R.id.btnTambahData);
        btnSimpanPenyakit = (Button) findViewById(R.id.btnTambahDataPenyakit);




        tvAddKode.setText("Kode Gejala");
        tvAddNama.setText("Nama Gejala");

        tvAddPenyebab.setVisibility(View.INVISIBLE);
        edtAddPenyebab.setVisibility(View.INVISIBLE);


        btnSimpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //empty Kode
                String keyEmptyAddKode = edtAddKode.getText().toString();
                String keyEmptyAddNama = edtAddNama.getText().toString();

                //write database
                SQLiteDatabase sql_add = dbhelper.getWritableDatabase();


                sql_add.execSQL("INSERT INTO tbl_gejala (kode_gejala, nama_gejala) VALUES('" +
                        edtAddKode.getText().toString() + "', '" +
                        edtAddNama.getText().toString() + "')");


                if (keyEmptyAddKode.isEmpty() && keyEmptyAddNama.isEmpty()) {
                    Toast.makeText(getApplication(), "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else

                    Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                //merefress

            }
        });


        //btn Tambah Penyakit
        btnSimpanPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Empty Kode
                String keyEmptyAddKode = edtAddKode.getText().toString();
                String keyEmptyAddNama = edtAddNama.getText().toString();
                String keyEmptyAddPenyebab = edtAddPenyebab.getText().toString();


                //write database
                SQLiteDatabase sql_add = dbhelper.getWritableDatabase();


                sql_add.execSQL("INSERT INTO tbl_penyakit (kode_penyakit, nama_penyakit, penyebab) VALUES('" +
                        edtAddKode.getText().toString() + "', '" +
                        edtAddNama.getText().toString() + "', '" +
                        edtAddPenyebab.getText().toString() + "')");


                if (keyEmptyAddKode.isEmpty() && keyEmptyAddNama.isEmpty()) {
                    Toast.makeText(getApplication(), "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else

                    Toast.makeText(getApplicationContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                //merefress

            }
        });
    }
}