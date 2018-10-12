package com.ieitlabs.masud.almahmud;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

public class TitleChildViewerHolder extends ChildViewHolder {

    public TextView option1;
    public TitleChildViewerHolder(View itemView){
        super(itemView);
        option1 = itemView.findViewById(R.id.option1);
    }

}
