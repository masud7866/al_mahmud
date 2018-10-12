package com.ieitlabs.masud.almahmud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("আল মাহমুদ ২০১৮ ইং");

        Button school = findViewById(R.id.school);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SchoolActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button hadith = findViewById(R.id.hadith);
        hadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HadithActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
