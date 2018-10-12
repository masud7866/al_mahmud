package com.ieitlabs.masud.almahmud;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TitleCreator {
    static TitleCreator _titlecreator;
    List<TitleParent> _titleparents;

    public TitleCreator(Context context) {
        _titleparents = new ArrayList<>();
        String[] stringArray = context.getResources().getStringArray(R.array.hadith);
        TitleParent title;
        for(String s:stringArray) {
            title = new TitleParent(String.format(s));
            _titleparents.add(title);
        }
    }

    public static TitleCreator get(Context context){
        if(_titlecreator==null)
            _titlecreator = new TitleCreator(context);
        return _titlecreator;
    }

    public List<TitleParent> getAll() {
        return _titleparents;
    }
}
