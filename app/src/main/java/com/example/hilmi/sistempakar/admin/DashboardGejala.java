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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardGejala extends Fragment {

     DbHelper dbSQLite;
    protected Cursor cursor;

    ArrayAdapter<String> adapter;

    String [] dashboard_gejala;
    ListView lvGejala;

    ArrayList<String> ListData;


    public static DashboardGejala refreshGejala;


    public DashboardGejala() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.dashboard_gejala, container, false);


        ListData = new ArrayList<>();
        lvGejala = (ListView) rootView.findViewById(R.id.lvDashboard);


        //handle tambah data
        FloatingActionButton btn_fab = (FloatingActionButton) rootView.findViewById(R.id.fab_tambahdata);
        btn_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), TambahData.class);
                startActivity(i);
            }
        });


        //membaca data
        refreshGejala = this;
        dbSQLite = new DbHelper(getActivity());
        setFrmRefresh();



//
////lihat data di list
//        dbSQLite = new DbHelper(getContext());
//        SQLiteDatabase db_gejala = dbSQLite.getReadableDatabase();
//        cursor = db_gejala.rawQuery("SELECT * FROM tbl_gejala", null);
//        dashboard_gejala = new String[cursor.getCount()];
//
//
//
//        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal
//        //Melooping Sesuai Dengan Jumlan Data (Count) pada cursor
//        for(int count=0; count < cursor.getCount(); count++){
//
//            cursor.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir
//            dashboard_gejala[count] = cursor.getString(1).toString();
//
//
//        }
//
//
////        //handle to looping
////       // cursor.moveToNext();
////        //cursor.getColumnCount();
////        for (int i = 0; i < cursor.getCount(); i++) {
////            cursor.moveToPosition(i);
////            dashboard_gejala[i] = cursor.getString(1).toString();
////            //cursor.getString(1) isi dari filed 2
////            }







        //handle click
        lvGejala.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {

                final String selection = dashboard_gejala [arg2];
                final CharSequence[] dialogitem = {"Lihat", "Update", "Hapus"};
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getContext(), LihatData.class);
                                i.putExtra("nama_gejala", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in_update = new Intent(getContext(), UbahData.class);
                                in_update.putExtra("nama_gejala", selection);
                                startActivity(in_update);
                                break;
                            case 2:
                                SQLiteDatabase db = dbSQLite.getWritableDatabase();
                                db.execSQL("delete from tbl_gejala WHERE nama_gejala = '" + selection + "'");
                                Toast.makeText(getActivity(), "Berhasil dihapus", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });


        ((ArrayAdapter) lvGejala.getAdapter()).notifyDataSetInvalidated();
        return rootView;
    }


    //refresh
    public void setFrmRefresh()
    {
        SQLiteDatabase db = dbSQLite.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbl_gejala",null);
        dashboard_gejala = new String[cursor.getCount()];
        cursor.moveToFirst();




        //loping
        for (int i=0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            dashboard_gejala[i] = cursor.getString(1).toString();
        }

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dashboard_gejala);
        lvGejala.setAdapter(adapter);
        lvGejala.setSelected(true);
    }


}
