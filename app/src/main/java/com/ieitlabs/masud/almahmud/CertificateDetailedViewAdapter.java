package com.ieitlabs.masud.almahmud;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CertificateDetailedViewAdapter extends RecyclerView.Adapter<CertificateDetailedViewAdapter.CertificateDetailedViewHolder> {
    private ArrayList<String> mDataset;
    LayoutInflater inflater;
    private Context context;
    class CertificateDetailedViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextview;

        public CertificateDetailedViewHolder(View itemView) {
            super(itemView);
            mTextview = itemView.findViewById(R.id.parentTitle);
        }
    }

    public void setmDataset(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
    }

    public CertificateDetailedViewAdapter(ArrayList<String> myDataset, Context mContext) {
            inflater = LayoutInflater.from(mContext);
            mDataset = myDataset;

            context = mContext;
        }

        @Override
        public CertificateDetailedViewAdapter.CertificateDetailedViewHolder onCreateViewHolder(ViewGroup parent,
                                                                               int viewType) {
            View view = inflater.inflate(R.layout.layout_parent,parent,false);
            return new CertificateDetailedViewAdapter.CertificateDetailedViewHolder(view);
        }
        @Override
        public void onBindViewHolder( CertificateDetailedViewAdapter.CertificateDetailedViewHolder holder,  int position) {

            final Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
            holder.mTextview.setTypeface(custom_font);

            holder.mTextview.setText(mDataset.get(position));

        }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

