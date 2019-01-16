package com.example.hilmi.sistempakar.admin;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.db.DbHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardPenyakit extends Fragment {


    DbHelper dbCenter;
    protected Cursor cursor;
    ArrayAdapter<String> adapter;

    String [] dashboard_penyakit;
    ListView lvPenyakit;


    DashboardPenyakit refreshPenyakit;




    public DashboardPenyakit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.dashboard_gejala, container, false);


        lvPenyakit = (ListView) rootView.findViewById(R.id.lvDashboard);

        dbCenter = new DbHelper(getActivity());


        refreshPenyakit = this;
        dbCenter = new DbHelper(getActivity());
        setFrmRefresh();



//        cursor = sql_penyakit.rawQuery("SELECT * FROM tbl_penyakit", null);
//        dashboard_penyakit= new String[cursor.getCount()];
//        cursor.moveToFirst();
//
//
//
//
//        //handle
//        //looping
//
//        for (int i=0; i < cursor.getCount(); i++){
//            cursor.moveToPosition(i);
//            dashboard_penyakit[i] = cursor.getString(1).toString();
//        }
//
//
//        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dashboard_penyakit);
//        lvPenyakit.setAdapter(adapter);



        //handle
        lvPenyakit.setSelected(true);
        lvPenyakit.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {

                final String selection = dashboard_penyakit [arg2];
                final CharSequence[] dialogitem = {"Lihat", "Update", "Hapus"};
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getContext(), LihatData.class);
                                i.putExtra("nama_penyakit", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in_update = new Intent(getContext(), UbahData.class);
                                in_update.putExtra("nama_penyakit", selection);
                                startActivity(in_update);
                                break;
                            case 2:
                                SQLiteDatabase db = dbCenter.getWritableDatabase();
                                db.execSQL("delete from tbl_penyakit WHERE nama_penyakit = '" + selection + "'");
                                Toast.makeText(getActivity(), "Berhasil dihapus", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        ((ArrayAdapter) lvPenyakit.getAdapter()).notifyDataSetInvalidated();


        //handle tambah data
        FloatingActionButton btn_fab = (FloatingActionButton)rootView. findViewById(R.id.fab_tambahdata);
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), TambahData.class);
                startActivity(i);
            }
        });




        return rootView;
    }


    //refresh
    public void setFrmRefresh()
    {
        SQLiteDatabase db = dbCenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbl_penyakit",null);
        dashboard_penyakit = new String[cursor.getCount()];
        cursor.moveToFirst();




        //loping
        for (int i=0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            dashboard_penyakit[i] = cursor.getString(1).toString();
        }

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dashboard_penyakit);
        lvPenyakit.setAdapter(adapter);
        lvPenyakit.setSelected(true);
    }


}
