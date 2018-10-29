package com.ieitlabs.masud.almahmud;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

public class TitleAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewerHolder> {

    LayoutInflater inflater;
    Context mContext;

    public TitleAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.layout_parent,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewerHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.layout_child,viewGroup,false);
        return new TitleChildViewerHolder(view, mContext);

    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder TitleParentViewHolder, int i, Object o) {
        TitleParent title = (TitleParent) o;
        Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        TitleParentViewHolder._textView.setTypeface(custom_font);
        TitleParentViewHolder._textView.setText(Html.fromHtml(title.getTitle()));

    }

    @Override
    public void onBindChildViewHolder(TitleChildViewerHolder TitleChildViewerHolder, int i, Object o) {
        TitleChild title = (TitleChild) o;
        Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        TitleChildViewerHolder.option1.setTypeface(custom_font);
        TitleChildViewerHolder.option1.setText(Html.fromHtml(title.getOption1()));


    }
}
