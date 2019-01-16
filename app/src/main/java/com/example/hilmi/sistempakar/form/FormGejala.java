package com.example.hilmi.sistempakar.form;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hilmi.sistempakar.admin.LihatData;
import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.db.DbHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormGejala extends Fragment {

    DbHelper myDatabaseSql;
    protected Cursor cursor;

    String[] daftar_gejala;
    ListView lvGejala;
    ArrayAdapter<String> adapter;

    public static FormGejala frmRefresh;



    public FormGejala() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_form_gejala, container, false);


        lvGejala = (ListView) rootView.findViewById(R.id.list_gejala);


        ///read

        frmRefresh = this;
        //membaca database
        myDatabaseSql = new DbHelper(getActivity());
        setFrmRefresh();







        //klik
        lvGejala.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar_gejala[arg2];
                Intent i = new Intent(getContext(), LihatData.class);
                i.putExtra("nama_gejala", selection);
                startActivity(i);
            }
        });



        return rootView;
    }



    //refresh
    public void setFrmRefresh()
    {
        SQLiteDatabase db = myDatabaseSql.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbl_gejala",null);
        daftar_gejala = new String[cursor.getCount()];
        cursor.moveToFirst();



        //loping
        for (int i=0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar_gejala[i] = cursor.getString(1).toString();
        }

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, daftar_gejala);
        lvGejala.setAdapter(adapter);
        lvGejala.setSelected(true);
    }

}
