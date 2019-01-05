package com.example.hilmi.sistempakar.admin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.db.DbHelper;

public class LihatData extends AppCompatActivity {

    DbHelper dbLihatData;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_data);


        TextView tv1 = (TextView)findViewById(R.id.tv1);
        TextView tv2 = (TextView)findViewById(R.id.tv2);
        TextView tv3 = (TextView)findViewById(R.id.tv3);

        TextView tvKode     = (TextView) findViewById(R.id.tvlihatKode);
        TextView tvNm       = (TextView) findViewById(R.id.tvlihatNama);
        TextView tvSolusi   = (TextView) findViewById(R.id.tvlihatSolusi);





        dbLihatData = new DbHelper(this);

        //hanndle lihat form gejala
        //melihat data dari formGejala
        SQLiteDatabase form_lihat_gejala = dbLihatData.getReadableDatabase();
        dbLihatData.createTableGejala(form_lihat_gejala);
        dbLihatData.isiTableGejala(form_lihat_gejala);

        cursor = form_lihat_gejala.rawQuery("SELECT * FROM tbl_gejala WHERE nama_gejala= '" + getIntent().getStringExtra("nama_gejala") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            tvKode.setText(cursor.getString(0).toString());
            tvNm.setText(cursor.getString(1).toString());

            //
            tv1.setText("Kode Gejala");
            tv2.setText("Nama Gejala");
            tv3.setVisibility(View.GONE);
            tvSolusi.setVisibility(View.GONE);
        }



        //hanndle lihat form Penyakit
        //melihat data dari formPenyakit
        SQLiteDatabase form_lihat_penyakit = dbLihatData.getReadableDatabase();
        dbLihatData.createTablePenyakit(form_lihat_penyakit);
        dbLihatData.isiTablePenyakit(form_lihat_penyakit);

        cursor = form_lihat_penyakit.rawQuery("SELECT * FROM tbl_penyakit WHERE nama_penyakit= '" + getIntent().getStringExtra("nama_penyakit") + "'", null);
//        cursor = form_lihat_gejala.rawQuery("SELECT kode_penyakit, nama_penyakit FROM tbl_penyakit INNER JOIN tbl_solusi ON kode_penyakit = kode_solusi ", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            tvKode.setText(cursor.getString(0).toString());
            tvNm.setText(cursor.getString(1).toString());

            //
            tv1.setText("Kode Penyakit");
            tv2.setText("Nama Penyakit");
            tv3.setVisibility(View.GONE);
            tvSolusi.setVisibility(View.GONE);
        }
    }
}
