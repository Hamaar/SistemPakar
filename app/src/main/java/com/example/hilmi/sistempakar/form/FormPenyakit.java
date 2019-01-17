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
public class FormPenyakit extends Fragment {

    DbHelper dbCenter;
    protected Cursor cursor;

    String [] daftar_penyakit;
    ArrayAdapter<String> adapter;

    ListView lvPenyakit;



    public FormPenyakit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_form_penyakit, container, false);

        lvPenyakit = (ListView) rootView.findViewById(R.id.list_penyakit);

        dbCenter = new DbHelper(getActivity());
        SQLiteDatabase sql_form_penyakit = dbCenter.getReadableDatabase();


        cursor = sql_form_penyakit.rawQuery("SELECT * FROM tbl_penyakit", null);
        daftar_penyakit = new String[cursor.getCount()];

        //looping
        for (int i=0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar_penyakit[i] = cursor.getString(1).toString();
        }


        //listView
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, daftar_penyakit);
        lvPenyakit.setAdapter(adapter);
        lvPenyakit.isSelected();


        //klik
        lvPenyakit.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar_penyakit[arg2];
                Intent i = new Intent(getContext(), LihatData.class);
                i.putExtra("nama_penyakit", selection);
                startActivity(i);
            }
        });







        return rootView;
    }

}
