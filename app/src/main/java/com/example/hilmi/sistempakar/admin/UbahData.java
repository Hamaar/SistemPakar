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

public class UbahData extends AppCompatActivity {

    DbHelper dbPunyGejala, dbPunyaPenyakit;
    protected Cursor cursor;

    DbHelper dbCenter;

    EditText edtKode, edtNama, edtPenyebab, edtSolusi;
    TextView tvUbahKode, tvUbahNama, tvUbahPenyebab, tvUbahSolusi;
    Button btnUbah, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_data);

        //variable
        dbCenter = new DbHelper(this);
        dbPunyaPenyakit = new DbHelper(this);


        //textView
        tvUbahKode      = (TextView)findViewById(R.id.tvUbahKode);
        tvUbahNama      = (TextView)findViewById(R.id.tvUbahNama);
        tvUbahPenyebab  = (TextView)findViewById(R.id.tvUbahPenyebab);
        tvUbahSolusi    = (TextView)findViewById(R.id.tvUbahSolusi);

        //EditText
        edtKode     = (EditText)findViewById(R.id.edt_ubah_kode);
        edtNama     = (EditText)findViewById(R.id.edt_ubah_nama);
        edtPenyebab = (EditText)findViewById(R.id.edt_ubah_Penyebab);
        edtSolusi   = (EditText)findViewById(R.id.edt_ubah_solusi);


        //button
        btnUbah = (Button)findViewById(R.id.btnUbahData);
        btnReset = (Button)findViewById(R.id.btnReset);



        //handle
        //membaca table gejala ketika klik update
        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbl_gejala WHERE nama_gejala = '" + getIntent().getStringExtra("nama_gejala") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            edtKode.setText(cursor.getString(0).toString());
            edtNama.setText(cursor.getString(1).toString());

            tvUbahKode.setText("Kode Gejala");
            tvUbahNama.setText("Nama Gejala");

            //nonaktifkan
            edtPenyebab.setVisibility(View.GONE);
            edtSolusi.setVisibility(View.INVISIBLE);
            tvUbahPenyebab.setVisibility(View.INVISIBLE);
            tvUbahSolusi.setVisibility(View.INVISIBLE);

        }




            //handle UBAH DATA PENYAKIT
        //handle table gejala
        SQLiteDatabase sql_penyakit = dbCenter.getReadableDatabase();



        cursor = sql_penyakit.rawQuery("SELECT * FROM tbl_penyakit WHERE nama_penyakit='" + getIntent().getStringExtra("nama_penyakit") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            edtKode.setText(cursor.getString(0).toString());
            edtNama.setText(cursor.getString(1).toString());
            edtPenyebab.setText(cursor.getString(2).toString());

            //textView
            tvUbahKode.setText("Kode Penyakit");
            tvUbahNama.setText("Nama Penyakit");

            //nonaktifkan
            edtSolusi.setVisibility(View.INVISIBLE);
            tvUbahSolusi.setVisibility(View.INVISIBLE);
        }





        //btn ubah data Gejala
        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String keyKode = edtKode.getText().toString();
                String keyNama = edtNama.getText().toString();
                String keyPenyebab = edtPenyebab.getText().toString();


                if (keyKode.isEmpty() && keyNama.isEmpty() && keyPenyebab.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();

                }

                    //handle
                    //update table gejala
                    SQLiteDatabase dbGeja = dbCenter.getWritableDatabase();
                    dbGeja.execSQL("UPDATE tbl_gejala set nama_gejala='" +
                            edtNama.getText().toString() + "', kode_gejala='" +
                            edtKode.getText().toString() + "' WHERE kode_gejala='" +
                            edtKode.getText().toString() + "'");


                //handle
                //update table Penyakit
                //update table gejala
                SQLiteDatabase dbPenyakit = dbCenter.getWritableDatabase();
                dbPenyakit.execSQL("UPDATE tbl_penyakit set nama_penyakit='" +
                        edtNama.getText().toString() + "', kode_penyakit='" +
                        edtPenyebab.getText().toString() + "', penyebab='" +

                        edtKode.getText().toString() + "' WHERE kode_penyakit='" +
                        edtKode.getText().toString() + "'");

//

                Toast.makeText(getApplicationContext(), "Berhasil diupdate", Toast.LENGTH_LONG).show();
//                DashboardGejala.refreshGejala.setFrmRefresh();
//                finish();

            }
        });






     btnReset.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             edtKode.setText("");
             edtNama.setText("");
             edtPenyebab.setText("");

         }
     });
    }
}
