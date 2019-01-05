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
import com.example.hilmi.sistempakar.db.DbHelper;
import com.example.hilmi.sistempakar.helpers.SQLiteHelper;
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
    private List<Gejala> listgejalas;
    private EditText txtSearch;
    SQLiteDatabase sqlDbBaru;



    DbHelper myDatabaseSql;
    Cursor cursor;

    String [] daftar_gejala;
    ListView lvGejala;
    ArrayAdapter<String> adapter;



    Button btnProsesDiagnosa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_diagnosa);

        listGejala = (ListView)findViewById(R.id.listGejala);
        btnDiagnosa = (Button)findViewById(R.id.btnDiagnosa);
        txtSearch = (EditText)findViewById(R.id.txtSearch);



        myDatabaseSql = new DbHelper(this);
        lvGejala = (ListView) findViewById(R.id.listGejala);

        //membaca database
        myDatabaseSql = new DbHelper(this);
        SQLiteDatabase db_gejala = myDatabaseSql.getReadableDatabase();
        myDatabaseSql.createTableGejala(db_gejala);
        myDatabaseSql.isiTableGejala(db_gejala);


        cursor = db_gejala.rawQuery("SELECT * FROM tbl_gejala", null);
        daftar_gejala = new String[cursor.getCount()];
        cursor.moveToFirst();

        //loping
        for (int i=0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar_gejala[i] = cursor.getString(1).toString();
        }


        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.select_dialog_multichoice, daftar_gejala);
        listGejala.setAdapter(adapter);
        listGejala.setChoiceMode(listGejala.CHOICE_MODE_MULTIPLE);
        listGejala.setSelected(true);




        //handle to search
        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //search
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //membaca database
                myDatabaseSql = new DbHelper(getApplicationContext());
                SQLiteDatabase db_gejala = myDatabaseSql.getReadableDatabase();
                myDatabaseSql.createTableGejala(db_gejala);
                myDatabaseSql.isiTableGejala(db_gejala);


                cursor = db_gejala.rawQuery("SELECT * FROM tbl_gejala", null);
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

                SparseBooleanArray checked = listGejala.getCheckedItemPositions();
                if (checked.size() <= listgejalas.size()) {
                    ArrayList<Gejala> selectedItems = new ArrayList<Gejala>();
                    for (int i = 0; i < checked.size(); i++) {
                        int pos = checked.keyAt(i);
                        if (checked.valueAt(i))
                            selectedItems.add((Gejala) gia.getItem(pos));
                    }

                    String[] outArr = new String[selectedItems.size()];
                    for (int j = 0; j < selectedItems.size(); j++) {
                        outArr[j] = selectedItems.get(j).getGid();
                    }

                    Intent i = new Intent(FormDiagnosa.this, FormHasilDiagnosa.class);
                    Bundle b = new Bundle();
                    b.putStringArray("selectedItems", outArr);
                    i.putExtras(b);
                    startActivity(i);
                } else {
                    Toast.makeText(FormDiagnosa.this, "Gejala tidak boleh dipilih semua", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }



////
////
////                //loping
////                for (int i = 0; i < cursor.getCount(); i++) {
////                    cursor.moveToPosition(i);
////                    daftar_diagnosa[i] = cursor.getString(1).toString();
////
////
////                if (lvDiagnosa.isItemChecked(0)) {
////                        Toast.makeText(getApplicationContext(), "" + daftar_diagnosa[i], Toast.LENGTH_SHORT).show();
////                    break;
////                }
////                if (lvDiagnosa.isItemChecked(1)) {
////                        Toast.makeText(getApplicationContext(), ""  +daftar_diagnosa[i], Toast.LENGTH_SHORT).show();
////                    break;
////                }
////                if (lvDiagnosa.isItemChecked(2)) {
////                        Toast.makeText(getApplicationContext(), "" + daftar_diagnosa[i], Toast.LENGTH_SHORT).show();
////                    break;
////                }
////                if (lvDiagnosa.isItemChecked(3)) {
////                        Toast.makeText(getApplicationContext(), "" + daftar_diagnosa[i], Toast.LENGTH_SHORT).show();
////                    break;
////                }
////                if (lvDiagnosa.isItemChecked(4)) {
////                        Toast.makeText(getApplicationContext(), ""  +daftar_diagnosa[i], Toast.LENGTH_SHORT).show();
////                    break;
////                }
////                if (lvDiagnosa.isItemChecked(5)) {
////                        Toast.makeText(getApplicationContext(), "" + daftar_diagnosa[i], Toast.LENGTH_SHORT).show();
////                    break;
////                }
////
////                    else {
////                        Toast.makeText(getApplicationContext(), "Data elum dipilih", Toast.LENGTH_SHORT).show();
////                        break;
////
////                    }
//                }
//            }
//
//        });
//    }
//}
