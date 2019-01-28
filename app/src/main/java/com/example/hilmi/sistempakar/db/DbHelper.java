package com.example.hilmi.sistempakar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.hilmi.sistempakar.models.Keputusan;

/**
 * Created by hilmi on 04/01/2019.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sistempakar.db";

    public DbHelper (Context context){
        super(context, DATABASE_NAME, null, 1);

    }


    //handle create Table Gejala
    public void createTableGejala(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS tbl_gejala");
        db.execSQL("CREATE TABLE if not exists tbl_gejala (kode_gejala TEXT PRIMARY KEY, nama_gejala TEXT);");
    }

    //handle create table Penyakit
    public void createTablePenyakit(SQLiteDatabase dbPenyakit)
    {
        dbPenyakit.execSQL("DROP TABLE IF EXISTS tbl_penyakit");
        dbPenyakit.execSQL("CREATE TABLE if not exists tbl_penyakit (kode_penyakit TEXT PRIMARY KEY, nama_penyakit TEXT, penyebab TEXT)");
    }

    //handle create table solusi
    public void createTableSolusi(SQLiteDatabase dbSolusi)
    {
        dbSolusi.execSQL("DROP TABLE IF EXISTS tbl_solusi");
        dbSolusi.execSQL("CREATE TABLE IF NOT EXISTS tbl_solusi (kode_solusi TEXT PRIMARY KEY, nama_solusi TEXT)");
    }

    //handle create table keputusan
    public void createTableKeputusan(SQLiteDatabase dbKeputusan)
    {
        dbKeputusan.execSQL("DROP TABLE IF EXISTS tbl_keputusan");
        dbKeputusan.execSQL("CREATE TABLE IF NOT EXISTS tbl_keputusan (key_id INTEGER PRIMARY KEY, key_penyakit TEXT, key_gejala TEXT)");
    }






    //handle isi table
    public void isiTableGejala(SQLiteDatabase db) {
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G1', 'mata mengeluarkan cairan');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G2', 'kelopak bagian mata membengkak');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G3', 'terlihat mengantuk mengantuk');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G4', 'kotoran cair');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G5', 'kotoran putih seperti kapur');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G6', 'kotoran seperti cacing');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G7', 'tulang dada tipis menonjol');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G8', 'perut terlihat membesar');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G9', 'pembengkakan kloaka atau anus');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G10', 'warna bulu terlihat rusak');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G11', 'bulu menggembang');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G12', 'hidung sering mengeluarkan cairan');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G13', 'kaki membengkak');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G14', 'nafas tersedat-sedat');");

    }

    //handle isi table penyakit
    public void isiTablePenyakit(SQLiteDatabase dbPenyakit)
    {
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P1', 'Penyakit SNOT CORZYA', 'mata');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P2', 'Penyakit Berak Diare', 'mata');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P3', 'Penyakit Berak Kapur', 'mata');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P4', 'Penyakit Nyilet Atau Kurus', 'mata');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P5', 'Penyakit Egg Binding', 'mata');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P6', 'Penyakit Bulu', 'mata');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P7', 'Penyakit Ganguan Pernafasan', 'mata');");

    }

    //handle isi solusi
    public void isiTableSolusi(SQLiteDatabase dbSolusi)
    {
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P1', 'G2, G4, G11');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P2', 'G4, G10');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P3', 'G3, G5, G9');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P4', 'G3, G6, G9');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P5', 'G7, G8, G10');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P6', 'G9, G10');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P7', 'G3, G11, G14');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('P8', 'G10, G12');");
    }

//    public void isiTableKeputusan(SQLiteDatabase dbKeputusan)
//    {
//        dbKeputusan.execSQL("INSERT INTO tbl_keputusan VALUES ('P01', 'G01', 'S1')");
//        dbKeputusan.execSQL("INSERT INTO tbl_keputusan VALUES ('P01', 'G01', 'S1')");
//    }




    //MENGHAPUS TABLE
    private static final String SCRIPT_DELETE_TABLE="DROP TABLE IF EXISTS " + DATABASE_NAME;



    //
    @Override
    public void onCreate(SQLiteDatabase db) {

      createTableGejala(db);
      isiTableGejala(db);
      createTablePenyakit(db);
      isiTablePenyakit(db);
      createTableSolusi(db);
      isiTableSolusi(db);
      createTableKeputusan(db);
      //isiTableKeputusan(db);

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
        db.execSQL(SCRIPT_DELETE_TABLE);

    }



}
