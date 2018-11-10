package com.ieitlabs.masud.almahmud;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

public class SchoolActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        setTitle("জামিয়া পরিচিতি");
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setSubtitle(Html.fromHtml("<small>জামিয়া ইসলামিয়া দারুল উলূম মাদানিয়া, যাত্রাবাড়ী, ঢাকা</small>"));

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");

        for(int i = 0; i < myToolbar.getChildCount(); i++) {
            View view = myToolbar.getChildAt(i);
            if(view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setTypeface(custom_font);
            }
        }

        recyclerView = findViewById(R.id.school_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TitleAdapter adapter = new TitleAdapter(this,initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);
        recyclerView.setAdapter(adapter);
    }

    private List<ParentObject> initData() {
        String[] stringArray = this.getResources().getStringArray(R.array.school_details);
        SchoolTitleCreator titleCreator = SchoolTitleCreator.get(this);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();
        int count = 0;
        for(TitleParent title:titles)
        {
            List<Object> childList = new ArrayList<>();
            childList.add(new TitleChild(stringArray[count]));
            title.setChildObjectList(childList);
            parentObject.add(title);
            count++;
        }
        return parentObject;
    }
}
