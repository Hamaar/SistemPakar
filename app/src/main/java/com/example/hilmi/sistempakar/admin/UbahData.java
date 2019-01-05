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

    private DbHelper dbPunyGejala, dbPunyaPenyakit;
    Cursor cursor;

    EditText edtKode, edtNama, edtSolusi;
    TextView tvUbahKode, tvUbahNama, tvUbahSolusi;
    Button btnUbah, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_data);

        //variable
        edtKode     = (EditText)findViewById(R.id.edt_ubah_kode);
        edtNama     = (EditText)findViewById(R.id.edt_ubah_nama);
        edtSolusi   = (EditText)findViewById(R.id.edt_ubah_solusi);

        //textView
        tvUbahKode  = (TextView)findViewById(R.id.tvUbahKode);
        tvUbahNama  = (TextView)findViewById(R.id.tvUbahNama);
        tvUbahSolusi = (TextView)findViewById(R.id.tvUbahSolusi);

        //button
        btnUbah = (Button)findViewById(R.id.btnUbahData);
        btnReset = (Button)findViewById(R.id.btnReset);




        //handle membaca database SQLite
        dbPunyGejala = new DbHelper(this);
        dbPunyaPenyakit = new DbHelper(this);

        //handle table gejala
        SQLiteDatabase sqlGejala = dbPunyGejala.getReadableDatabase();
        dbPunyGejala.createTableGejala(sqlGejala);
        dbPunyGejala.isiTableGejala(sqlGejala);

        cursor = sqlGejala.rawQuery("SELECT * FROM tbl_gejala WHERE nama_gejala='" + getIntent().getStringExtra("nama_gejala") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            edtKode.setText(cursor.getString(0).toString());
            edtNama.setText(cursor.getString(1).toString());

            //textView
            tvUbahKode.setText("Kode Gejala");
            tvUbahNama.setText("Nama Gejala");

            //nonaktifkan
            edtSolusi.setVisibility(View.INVISIBLE);
            tvUbahSolusi.setVisibility(View.INVISIBLE);
            }





            //handle UBAH DATA PENYAKIT
        //handle table gejala
        SQLiteDatabase sqlPenyakit = dbPunyGejala.getReadableDatabase();
        dbPunyGejala.createTablePenyakit(sqlPenyakit);
        dbPunyGejala.isiTablePenyakit(sqlPenyakit);

        cursor = sqlPenyakit.rawQuery("SELECT * FROM tbl_penyakit WHERE nama_penyakit='" + getIntent().getStringExtra("nama_penyakit") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            edtKode.setText(cursor.getString(0).toString());
            edtNama.setText(cursor.getString(1).toString());

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

                if (keyKode.isEmpty() && keyNama.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Database Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }


                //handle
                //update table gejala
                SQLiteDatabase db_gejala = dbPunyGejala.getWritableDatabase();
                db_gejala.execSQL("UPDATE tbl_gejala set nama_gejala='" + edtNama.getText().toString() +
                        "', kode_gejala='" + edtKode.getText().toString() + "' WHERE kode_gejala='" +
                        edtKode.getText().toString() + "'");



                //handle
                //update table Penyakit
                SQLiteDatabase db_penyakit = dbPunyaPenyakit.getWritableDatabase();
                db_penyakit.execSQL("UPDATE tbl_penyakit set nama_penyakit='" + edtNama.getText().toString() +
                        "', kode_penyakit='" + edtKode.getText().toString() + "' WHERE kode_penyakit='" +
                        edtKode.getText().toString() + "'");



                Toast.makeText(getApplicationContext(), "Berhasil diupdate", Toast.LENGTH_LONG).show();

            }
        });






     btnReset.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             edtKode.setText("");
             edtNama.setText("");
         }
     });
    }
}
