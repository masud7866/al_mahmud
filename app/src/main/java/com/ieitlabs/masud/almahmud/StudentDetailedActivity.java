package com.ieitlabs.masud.almahmud;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentDetailedActivity extends AppCompatActivity {

    private String name, roll, dept, subdist, dist, clipData;
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

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        dept_year.setTypeface(custom_font);
        dept_year.setText(mDataset.get(0)+" সমাপনী "+mDataset.get(1)+"ইং/"+mDataset.get(2)+"হিঃ");

        TextView name = findViewById(R.id.name);
        name.setTypeface(custom_font);
        name.setText(mDataset.get(5));

        TextView father = findViewById(R.id.father);
        father.setTypeface(custom_font);
        father.setText("পিতা: "+mDataset.get(6));

        TextView roll = findViewById(R.id.roll);
        roll.setTypeface(custom_font);
        roll.setText("রোল: "+mDataset.get(3));

        TextView group = findViewById(R.id.group);
        group.setTypeface(custom_font);
        if (mDataset.get(4).equals("")){
            group.setVisibility(View.GONE);
        }
        else {
            group.setText("গ্রুপ: "+mDataset.get(4));
        }

        TextView subdistrict = findViewById(R.id.subdistrict);
        subdistrict.setTypeface(custom_font);
        subdistrict.setText("থানা: "+mDataset.get(7));

        TextView district = findViewById(R.id.district);
        district.setTypeface(custom_font);
        district.setText("জেলা: "+mDataset.get(8));

        TextView mobile = findViewById(R.id.mobile);
        mobile.setTypeface(custom_font);
        mobile.setText("মোবাইল নম্বর: "+mDataset.get(9));

        final String number = mDataset.get(9);

        if(mDataset.get(4).equals("")){
            clipData = dept_year.getText().toString()+"\n"+name.getText().toString()+"\n"+father.getText().toString()+"\n"+roll.getText().toString()+"\n"+subdistrict.getText().toString()+"\n"+district.getText().toString()+"\n"+mobile.getText().toString();
        }
        else {
            clipData = dept_year.getText().toString()+"\n"+name.getText().toString()+"\n"+father.getText().toString()+"\n"+roll.getText().toString()+"\n"+group.getText().toString()+"\n"+subdistrict.getText().toString()+"\n"+district.getText().toString()+"\n"+mobile.getText().toString();
        }

        Button copy = findViewById(R.id.copy);
        copy.setTypeface(custom_font);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", clipData);
                clipboard.setPrimaryClip(clip);
                Toast toast = Toast.makeText(getApplicationContext(),"লেখা কপি হয়েছে",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button call = findViewById(R.id.call);
        call.setTypeface(custom_font);
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
        sms.setTypeface(custom_font);
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
