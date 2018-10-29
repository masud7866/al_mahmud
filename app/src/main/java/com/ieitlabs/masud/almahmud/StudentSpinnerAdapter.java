package com.ieitlabs.masud.almahmud;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentSpinnerAdapter extends ArrayAdapter {
    LayoutInflater inflater;
    Context mContext;
    private ArrayList<String> mDataset;
    public StudentSpinnerAdapter(Context context, ArrayList<String> myDataset) {
        super(context, android.R.layout.simple_spinner_item, myDataset);
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        mDataset = myDataset;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView tv = (TextView) view;
        Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        if(position == 0){
            // Set the hint text color gray
            tv.setTextColor(Color.GRAY);
            tv.setTypeface(custom_font);
        }
        else {
            tv.setTextColor(Color.BLACK);
            tv.setTypeface(custom_font);
        }
        return view;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        view.setTypeface(custom_font);
        return view;
    }

}
