package com.ieitlabs.masud.almahmud;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentDetailedActivity extends AppCompatActivity {

    private String name, roll, dept, subdist, dist;
    private ArrayList<String> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detailed);

        name =  getIntent().getExtras().get("name").toString();
        roll = getIntent().getExtras().get("roll").toString();
        dept = getIntent().getExtras().get("dept").toString();
        subdist = getIntent().getExtras().get("subdist").toString();
        dist = getIntent().getExtras().get("dist").toString();

        mDataset = (new DBManager(this)).getStudentInfo(name,roll,dept,subdist,dist);

        TextView dept_year = findViewById(R.id.dept_year);
        dept_year.setText(mDataset.get(0)+" সমাপনী "+mDataset.get(1));

        TextView name = findViewById(R.id.name);
        name.setText(mDataset.get(4));

        TextView father = findViewById(R.id.father);
        father.setText("পিতা: "+mDataset.get(5));

        TextView roll = findViewById(R.id.roll);
        roll.setText("রোল: "+mDataset.get(2));

        TextView group = findViewById(R.id.group);
        group.setText("গ্রুপ: "+mDataset.get(3));

        TextView subdistrict = findViewById(R.id.subdistrict);
        subdistrict.setText("থানা: "+mDataset.get(6));

        TextView district = findViewById(R.id.district);
        district.setText("জেলা: "+mDataset.get(7));

        TextView mobile = findViewById(R.id.mobile);
        mobile.setText("মোবাইল নম্বর: "+mDataset.get(8));

        final String number = mDataset.get(8);

        Button call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!number.contains("/")){
                    String uri = "tel:" + number.trim() ;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                }
                else {
                    final String[] numbers = number.split(" / ");


                    AlertDialog.Builder builder = new AlertDialog.Builder(StudentDetailedActivity.this);
                    builder.setTitle("নম্বর পছন্দ করুন");
                    builder.setItems(numbers, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                            String uri = "tel:" + numbers[item].trim() ;
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse(uri));
                            startActivity(intent);
                        }
                    });
                    builder.show();
                }

            }
        });


        Button sms = findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!number.contains("/")){
                    String uri = "smsto:" + number.trim() ;
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                }
                else {
                    final String[] numbers = number.split(" / ");


                    AlertDialog.Builder builder = new AlertDialog.Builder(StudentDetailedActivity.this);
                    builder.setTitle("নম্বর পছন্দ করুন");
                    builder.setItems(numbers, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                            String uri = "smsto:" + numbers[item].trim() ;
                            Intent intent = new Intent(Intent.ACTION_SENDTO);
                            intent.setData(Uri.parse(uri));
                            startActivity(intent);
                        }
                    });
                    builder.show();
                }

            }
        });




    }
}
