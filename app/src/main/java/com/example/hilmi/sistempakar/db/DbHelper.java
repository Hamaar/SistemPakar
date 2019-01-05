package com.example.hilmi.sistempakar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hilmi on 04/01/2019.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sistempakar.db";

    public DbHelper (Context context){
        super(context, DATABASE_NAME, null, 1);}


    //handle create Table Gejala
    public void createTableGejala(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS tbl_gejala");
        db.execSQL("CREATE TABLE if not exists tbl_gejala (kode_gejala TEXT PRIMARY KEY, nama_gejala TEXT);");
    }

    //handle create table Penyakit
    public void createTablePenyakit(SQLiteDatabase dbPenyakit)
    {
        dbPenyakit.execSQL("DROP TABLE IF EXISTS tbl_penyakit");
        dbPenyakit.execSQL("CREATE TABLE if not exists tbl_penyakit (kode_penyakit TEXT PRIMARY KEY, nama_penyakit TEXT)");
    }

    //handle create table solusi
    public void createTableSolusi(SQLiteDatabase dbSolusi)
    {
        dbSolusi.execSQL("DROP TABLE IF EXISTS tbl_solusi");
        dbSolusi.execSQL("CREATE TABLEE IF NOT EXISTS tbl_solusi (kode_solusi TEXT PRIMARY KEY, nama_solusi TEXT)");
    }






    //handle isi table
    public void isiTableGejala(SQLiteDatabase db) {
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G01', 'mata mengeluarkan cairan');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G02', 'kelopak mata membengkak');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G03', 'terlihat mengantuk mengantuk');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G04', 'mata terlihat normal');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G05', 'kotoran cair');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G06', 'warna putih seperti kapur');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G07', 'kotoran normal');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G08', 'tulang dada tipis menonjol');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G09', 'tulang dada normal');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G10', 'perut terlihat membesar');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G11', 'perut nornal');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G12', 'warna bulu terlihat rusak');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G13', 'bulu mengembang');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G14', 'bulu normal');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G15', 'hidung mengeluarkan cairan');");
        db.execSQL("INSERT INTO tbl_gejala VALUES ('G16', 'hidung normal');");

    }

    //handle isi table penyakit
    public void isiTablePenyakit(SQLiteDatabase dbPenyakit)
    {
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P01', 'Penyakit SNOT CORZYA');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P02', 'Penyakit Berak Diare');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P03', 'Penyakit Berak Kapur');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P04', 'Penyakit SNOT Nyilet Atau Kurus');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P05', 'Penyakit Egg Binding');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P06', 'Penyakit Bulu');");
        dbPenyakit.execSQL("INSERT INTO tbl_penyakit VALUES ('P07', 'Penyakit Ganguan Pernafasan');");

    }

    //handle isi solusi
    public void isiTableSolusi(SQLiteDatabase dbSolusi)
    {
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('S01', 'Beri obat mata');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('S02', 'Beri obat mata');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('S03', 'Beri obat mata');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('S04', 'Beri obat mata');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('S05', 'Beri obat mata');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('S06', 'Beri obat mata');");
        dbSolusi.execSQL("INSERT INTO tbl_solusi VALUES('S07', 'Beri obat mata');");
    }




    //MENGHAPUS TABLE
    private static final String SCRIPT_DELETE_TABLE="DROP TABLE IF EXISTS " + DATABASE_NAME;



    //
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
        db.execSQL(SCRIPT_DELETE_TABLE);

    }
}
