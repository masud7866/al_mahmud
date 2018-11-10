package com.ieitlabs.masud.almahmud;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        setTitle("আল মাহমুদ ২০১৮ ইং");
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

        Button school = findViewById(R.id.school);
        school.setTypeface(custom_font);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SchoolActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button hadith = findViewById(R.id.hadith);
        hadith.setTypeface(custom_font);
        hadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HadithActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button certificate = findViewById(R.id.certificate);
        certificate.setTypeface(custom_font);
        certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CertificateActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button about = findViewById(R.id.about);
        about.setTypeface(custom_font);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button student = findViewById(R.id.student);
        student.setTypeface(custom_font);
        student.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View view){
                Intent intent = new Intent(MainActivity.this,StudentActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button web = findViewById(R.id.web);
        web.setTypeface(custom_font);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://dawatul-haq.com/"));
                startActivity(browserIntent);
            }
        });
    }
}
