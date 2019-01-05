package com.example.hilmi.sistempakar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.example.hilmi.sistempakar.R;
import com.example.hilmi.sistempakar.models.Gejala;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class GejalaItemAdapter extends BaseAdapter {
    private List<Gejala> gejalas;
    private Context context;
    private ArrayList<Gejala> arraylist;

    public GejalaItemAdapter(List<Gejala> gejalas, Context context) {
        this.gejalas = gejalas;
        this.context = context;
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(gejalas);
    }

    @Override
    public int getCount() {
        return gejalas.size();
    }

    @Override
    public Object getItem(int position) {
        return gejalas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.gejala_item_layout, parent, false);
        CheckedTextView textView = (CheckedTextView)rootView.findViewById(R.id.txtCheckGejala);
        textView.setText(gejalas.get(position).getGejala());
        return rootView;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        gejalas.clear();
        if (charText.length() == 0) {
            gejalas.addAll(arraylist);
        }
        else
        {
            for (Gejala gj : arraylist)
            {
                if (gj.getGejala().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    gejalas.add(gj);
                }
            }
        }
        notifyDataSetChanged();
    }
}

