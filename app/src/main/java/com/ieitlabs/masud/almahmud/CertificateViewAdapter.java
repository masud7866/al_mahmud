package com.ieitlabs.masud.almahmud;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class CertificateViewAdapter extends RecyclerView.Adapter<CertificateViewAdapter.CertificateViewHolder> {
    private LinkedHashMap<String, String> mDataset;
    LayoutInflater inflater;
    private Context context;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class CertificateViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        String keyname;
        View mItemView;

        public CertificateViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mTextView = itemView.findViewById(R.id.parentTitle);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CertificateViewAdapter(LinkedHashMap<String, String> myDataset,Context mContext) {
        inflater = LayoutInflater.from(mContext);
        mDataset = myDataset;
        this.context = mContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CertificateViewAdapter.CertificateViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = inflater.inflate(R.layout.layout_parent,parent,false);
        return new CertificateViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final CertificateViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Object[] keys = mDataset.keySet().toArray();
        Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        holder.mTextView.setTypeface(custom_font);
        holder.mTextView.setText(mDataset.get(keys[position].toString()));
        holder.keyname = keys[position].toString();

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,CertificateDetailedActivity.class);

                Bundle cert = new Bundle();
                cert.putString("key",holder.keyname);
                cert.putString("val",mDataset.get(keys[position].toString()));
                intent.putExtras(cert);
                context.startActivity(intent);


            }
        });



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}