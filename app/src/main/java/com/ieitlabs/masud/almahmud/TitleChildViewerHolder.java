package com.ieitlabs.masud.almahmud;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

public class TitleChildViewerHolder extends ChildViewHolder {

    public TextView option1;
    Context mContext;
    public TitleChildViewerHolder(View itemView, Context context){
        super(itemView);
        mContext = context;
        option1 = itemView.findViewById(R.id.option1);
        option1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", option1.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast toast = Toast.makeText(mContext,"লেখা কপি হয়েছে",Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }
        });
    }

}
