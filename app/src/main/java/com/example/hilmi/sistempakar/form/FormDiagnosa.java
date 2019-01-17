package com.example.hilmi.sistempakar.form;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.adapters.GejalaItemAdapter;
import com.example.hilmi.sistempakar.admin.DashboardGejala;
import com.example.hilmi.sistempakar.db.DbHelper;
import com.example.hilmi.sistempakar.models.Gejala;
import com.example.hilmi.sistempakar.models.Keputusan;
import com.example.hilmi.sistempakar.models.Penyakit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static com.example.hilmi.sistempakar.R.id.parent;

public class FormDiagnosa extends AppCompatActivity {

    private ListView listGejala;
    private GejalaItemAdapter gia;
    private Button btnDiagnosa;
    private Toolbar toolbar;
    private ArrayList<Gejala> listgejalas = new ArrayList<>();
    private EditText txtSearch;
    SQLiteDatabase sqlDbBaru;



    DbHelper dbCenter;
    protected Cursor cursor;

    String [] daftar_gejala;
    ListView lvGejala;
    ArrayAdapter<String> adapter;


    public static FormDiagnosa refreshDiagnosa;



    Button btnProsesDiagnosa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_diagnosa);

        listGejala = (ListView)findViewById(R.id.listGejala);
        btnDiagnosa = (Button)findViewById(R.id.btnDiagnosa);
        txtSearch = (EditText)findViewById(R.id.txtSearch);



        dbCenter = new DbHelper(this);
        lvGejala = (ListView) findViewById(R.id.listGejala);


        //membaca data
        refreshDiagnosa = this;
        dbCenter = new DbHelper(this);
        setFrmRefresh();

//
//
//
//        //membaca database
//        myDatabaseSql = new DbHelper(this);
//        final SQLiteDatabase db_gejala = myDatabaseSql.getReadableDatabase();
//        myDatabaseSql.createTableGejala(db_gejala);
//        myDatabaseSql.isiTableGejala(db_gejala);
//
//
//        cursor = db_gejala.rawQuery("SELECT * FROM tbl_gejala", null);
//        daftar_gejala = new String[cursor.getCount()];
//        cursor.moveToFirst();
//
//        //loping
//        for (int i=0; i< cursor.getCount(); i++){
//            cursor.moveToPosition(i);
//            daftar_gejala[i] = cursor.getString(1).toString();
//        }
//
//
//        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_multichoice, daftar_gejala);
//        listGejala.setAdapter(adapter);
//        listGejala.setChoiceMode(listGejala.CHOICE_MODE_MULTIPLE);
//        listGejala.setSelected(true);




        //handle to search in database
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //search
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //membaca database
                SQLiteDatabase db = dbCenter.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM tbl_gejala",null);
                daftar_gejala = new String[cursor.getCount()];
                cursor.moveToFirst();



                //menampilkan search
                adapter.getFilter().filter(s.toString());
                //gia.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        //btn proses diagnosa
        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 0; i < listGejala.getCount(); i++) {

                    if (listGejala.isItemChecked(i)) {

                        String tesGejala = String.valueOf(listGejala.getItemAtPosition(i));
                      //  System.out.println(tesGid);

                        Gejala objt = new Gejala("tes", tesGejala);
                        listgejalas.add(objt);

                        Toast.makeText(getApplicationContext(), "Gejala : "+tesGejala, Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(FormDiagnosa.this, FormHasilDiagnosa.class);
                        intent.putExtra("ITEMS", listgejalas);
                        startActivity(intent);
                    }

                }
            }

        });
    }



    //refresh page
    public void setFrmRefresh()
    {
        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbl_gejala",null);
        daftar_gejala = new String[cursor.getCount()];
        cursor.moveToFirst();



        //loping
        for (int i=0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar_gejala[i] = cursor.getString(1).toString();
        }


        //list Checkbox
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_multichoice, daftar_gejala);
        listGejala.setAdapter(adapter);
        listGejala.setChoiceMode(listGejala.CHOICE_MODE_MULTIPLE);
        listGejala.setSelected(true);
    }



}

