package com.ieitlabs.masud.almahmud;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class SchoolTitleCreator {
    static SchoolTitleCreator _titlecreator;
    List<TitleParent> _titleparents;

    public SchoolTitleCreator(Context context) {
        _titleparents = new ArrayList<>();
        String[] stringArray = context.getResources().getStringArray(R.array.school);
        TitleParent title;
        for(String s:stringArray) {
            title = new TitleParent(String.format(s));
            _titleparents.add(title);
        }
    }

    public static SchoolTitleCreator get(Context context){
        if(_titlecreator==null)
            _titlecreator = new SchoolTitleCreator(context);
        return _titlecreator;
    }

    public List<TitleParent> getAll() {
        return _titleparents;
    }
}
