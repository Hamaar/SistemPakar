package com.example.hilmi.sistempakar.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hilmi.sistempakar.models.Gejala;
import com.example.hilmi.sistempakar.models.Penyakit;
import com.example.hilmi.sistempakar.models.Keputusan;

import java.util.ArrayList;
import java.util.List;



public class SQLiteHelper extends SQLiteOpenHelper {
    static SQLiteHelper sqh;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TesKuV2";

    //TABLE
    private static final String TABLE_HAMA = "hama";
    private static final String TABLE_GEJALA = "gejala";
    private static final String TABLE_KEPUTUSAN = "keputusan";
    private static final String TABLE_BUDIDAYA = "budidaya";

    //KOLOM
    private static final String KEY_ID = "id";
    private static final String KEY_PID = "pid";
    private static final String KEY_GID = "gid";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_CARA = "cara";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";

    public static SQLiteHelper getInstance(Context context){
        if(sqh == null){
            sqh = new SQLiteHelper(context);
        }

        return sqh;
    }

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HAMA_TBL = "CREATE TABLE " + TABLE_HAMA + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_PID + " TEXT,"
                + KEY_NAMA + " TEXT,"
                + KEY_CARA + " TEXT" + ")";

        String CREATE_GEJALA_TBL = "CREATE TABLE " + TABLE_GEJALA + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_GID + " TEXT,"
                + KEY_NAMA + " TEXT" + ")";

        String CREATE_KEPUTUSAN_TBL = "CREATE TABLE " + TABLE_KEPUTUSAN + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_PID + " TEXT,"
                + KEY_GID + " TEXT" + ")";

        db.execSQL(CREATE_HAMA_TBL);
        db.execSQL(CREATE_GEJALA_TBL);
        db.execSQL(CREATE_KEPUTUSAN_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HAMA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KEPUTUSAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GEJALA);

        onCreate(db);
    }

    //HAMA
    public void addHama(Penyakit hama){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PID, hama.getPid());
        cv.put(KEY_NAMA, hama.getNama());
        cv.put(KEY_CARA, hama.getCara());

        db.insert(TABLE_HAMA, null ,cv);
        db.close();
    }

    public Penyakit getHama(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HAMA, new String[] {KEY_ID,KEY_PID, KEY_NAMA, KEY_CARA}, KEY_ID + "=?", new String[] { String.valueOf(id)}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Penyakit hama = new Penyakit(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return hama;
    }

    public Penyakit getHama(String keyset){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HAMA, new String[] {KEY_ID,KEY_PID, KEY_NAMA, KEY_CARA}, KEY_PID + "=?", new String[] { keyset }, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Penyakit hama = new Penyakit(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return hama;
    }

    public List<Penyakit> getAllHama(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Penyakit> hamas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_HAMA;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Penyakit hama = new Penyakit(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                hamas.add(hama);
            } while (cursor.moveToNext());
        }

        return hamas;
    }

    //GEJALA
    public void addGejala(Gejala gejala){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_GID, gejala.getGid());
        cv.put(KEY_NAMA, gejala.getGejala());

        db.insert(TABLE_GEJALA, null ,cv);
        db.close();
    }

    public Gejala getGejala(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_GEJALA, new String[] {KEY_ID,KEY_GID, KEY_NAMA}, KEY_ID + "=?", new String[] { String.valueOf(id)}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Gejala gejala = new Gejala(cursor.getInt(0), cursor.getString(1), cursor.getString(2));

        return gejala;
    }

    public List<Gejala> getAllGejala(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Gejala> gejalas = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_GEJALA;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Gejala gejala = new Gejala(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
                gejalas.add(gejala);
            } while (cursor.moveToNext());
        }

        return gejalas;
    }

    //KEPUTUSAN
    public void addKeputusan(Keputusan keputusan){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_GID, keputusan.getGid());
        cv.put(KEY_PID, keputusan.getPid());

        db.insert(TABLE_KEPUTUSAN, null ,cv);
        db.close();
    }

    public Keputusan getKeputusan(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_KEPUTUSAN, new String[] {KEY_ID,KEY_GID, KEY_PID}, KEY_ID + "=?", new String[] { String.valueOf(id)}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();

        Keputusan putusan = new Keputusan(cursor.getInt(0), cursor.getString(1), cursor.getString(2));

        return putusan;
    }

    public List<Keputusan> getAllKeputusan(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Keputusan> keputusans = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_KEPUTUSAN;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Keputusan keputusan = new Keputusan(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
                keputusans.add(keputusan);
            } while (cursor.moveToNext());
        }

        return keputusans;
    }


}
