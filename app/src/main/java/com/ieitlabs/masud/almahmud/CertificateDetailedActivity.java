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
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CertificateDetailedActivity extends AppCompatActivity {

    private String keyname,val;
    private ArrayList<String> mDataset;
    CertificateDetailedViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate_detailed);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (getIntent().hasExtra("key") && getIntent().hasExtra("val"))
        {
            keyname =  getIntent().getExtras().get("key").toString();
            val = getIntent().getExtras().get("val").toString();


        }

        setTitle(val);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setSubtitle(Html.fromHtml("<small>দাওরায়ে হাদিস, জামিয়া ইসলামিয়া দারুল উলূম মাদানিয়া, যাত্রাবাড়ী, ঢাকা</small>"));

        final Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");

        for(int i = 0; i < myToolbar.getChildCount(); i++) {
            View view = myToolbar.getChildAt(i);
            if(view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setTypeface(custom_font);
            }
        }

        mDataset = (new DBManager(this)).getCertificate(keyname,true);

        TextView certificate_title = findViewById(R.id.certificate_title);

        certificate_title.setTypeface(custom_font);

        certificate_title.setText("১৪৩৮-৩৯ হিজরি মোতাবেক ২০১৭-১৮ইং শিক্ষাবর্ষে পঠিত "+val+" পাঠ সিলসিলা");

        final RecyclerView RVCertificateView = findViewById(R.id.certificate_detailed_recycler_view);
        RVCertificateView.setHasFixedSize(true);
        final LinearLayoutManager certLayoutManager = new LinearLayoutManager(this);
        RVCertificateView.setLayoutManager(certLayoutManager);
        mAdapter = new CertificateDetailedViewAdapter(mDataset,this);
        RVCertificateView.setAdapter(mAdapter);

        final Button order = findViewById(R.id.order);
        order.setTypeface(custom_font);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(order.getText().toString().equals("অধঃক্রমে")){
                    order.setTypeface(custom_font);
                    order.setText("উর্ধ্বক্রমে");
                    mDataset = (new DBManager(getApplicationContext())).getCertificate(keyname,false);
                }
                else {
                    mDataset = (new DBManager(getApplicationContext())).getCertificate(keyname,true);
                    order.setTypeface(custom_font);
                    order.setText("অধঃক্রমে");
                }
                CertificateDetailedViewAdapter adapter = (CertificateDetailedViewAdapter) RVCertificateView.getAdapter();
                adapter.setmDataset(mDataset);
                adapter.notifyDataSetChanged();

            }
        });

    }
}
