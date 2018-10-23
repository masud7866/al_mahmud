package com.ieitlabs.masud.almahmud;

import android.content.Context;
import android.graphics.Color;
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
        if(position == 0){
            // Set the hint text color gray
            tv.setTextColor(Color.GRAY);
        }
        else {
            tv.setTextColor(Color.BLACK);
        }
        return view;
    }
}
