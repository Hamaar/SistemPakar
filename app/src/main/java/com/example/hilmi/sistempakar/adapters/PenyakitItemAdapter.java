package com.example.hilmi.sistempakar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.form.FormPenyakit;
import com.example.hilmi.sistempakar.models.Penyakit;

import java.util.List;



public class PenyakitItemAdapter extends BaseAdapter {
    private List<Penyakit> hamas;
    private Context context;

    public PenyakitItemAdapter(List<Penyakit> hamas, Context context) {
        this.hamas = hamas;
        this.context = context;
    }



    @Override
    public int getCount() {
        return hamas.size();
    }

    @Override
    public Object getItem(int position) {
        return hamas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = LayoutInflater.from(context).inflate(R.layout.hama_item_layout, parent, false);
        TextView txtHama = (TextView)root.findViewById(R.id.txtNamaHama);
        ImageView imgHama = (ImageView)root.findViewById(R.id.imgHama);
        txtHama.setText(hamas.get(position).getNama());
        return root;
    }
}
