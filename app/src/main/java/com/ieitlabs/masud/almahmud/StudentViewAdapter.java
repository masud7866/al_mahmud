package com.ieitlabs.masud.almahmud;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentViewAdapter extends RecyclerView.Adapter<StudentViewAdapter.StudentViewHolder> {
    private ArrayList<ArrayList<String>> mDataset;
    LayoutInflater inflater;
    private Context context;
    class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextview0;
        public TextView mTextview1;
        public TextView mTextview2;
        public TextView mTextview3;

        public StudentViewHolder(View itemView) {
            super(itemView);
            mTextview0 = itemView.findViewById(R.id.overview0);
            mTextview1 = itemView.findViewById(R.id.overview1);
            mTextview2 = itemView.findViewById(R.id.overview2);
            mTextview3 = itemView.findViewById(R.id.overview3);
        }
    }

    public void setmDataset(ArrayList<ArrayList<String>> mDataset) {
        this.mDataset = mDataset;
    }

    public StudentViewAdapter(ArrayList<ArrayList<String>> myDataset, Context mContext) {
        inflater = LayoutInflater.from(mContext);
        mDataset = myDataset;

        context = mContext;
    }

    @Override
    public StudentViewAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                           int viewType) {
        View view = inflater.inflate(R.layout.layout_overview,parent,false);
        return new StudentViewAdapter.StudentViewHolder(view);
    }
    @Override
    public void onBindViewHolder( StudentViewAdapter.StudentViewHolder holder,  int position) {

        ArrayList<String> rowData = mDataset.get(position);

        holder.mTextview0.setText(rowData.get(2));
        holder.mTextview1.setText("রোলঃ "+rowData.get(1));
        holder.mTextview2.setText(rowData.get(0)+" বিভাগ");
        holder.mTextview3.setText(rowData.get(3)+", "+rowData.get(4));


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
