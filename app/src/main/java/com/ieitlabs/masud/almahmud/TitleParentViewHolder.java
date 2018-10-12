package com.ieitlabs.masud.almahmud;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

public class TitleParentViewHolder extends ParentViewHolder {
    public TextView _textView;
    public TitleParentViewHolder(View itemView){
        super(itemView);
        _textView = itemView.findViewById(R.id.parentTitle);
    }


}
