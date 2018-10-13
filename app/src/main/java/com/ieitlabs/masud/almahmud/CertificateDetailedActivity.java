package com.ieitlabs.masud.almahmud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

        setTitle(val);




        if (getIntent().hasExtra("key") && getIntent().hasExtra("val"))
        {
            keyname =  getIntent().getExtras().get("key").toString();
            val = getIntent().getExtras().get("val").toString();


        }

         mDataset = (new DBManager(this)).getCertificate(keyname,true);

        TextView certificate_title = findViewById(R.id.certificate_title);
        certificate_title.setText("১৪৩৮-৩৯ হিজরি মোতাবেক ২০১৭-১৮ইং শিক্ষাবর্ষে পঠিত "+val+" পাঠ সিলসিলা");

        final RecyclerView RVCertificateView = findViewById(R.id.certificate_detailed_recycler_view);
        RVCertificateView.setHasFixedSize(true);
        final LinearLayoutManager certLayoutManager = new LinearLayoutManager(this);
        RVCertificateView.setLayoutManager(certLayoutManager);
        mAdapter = new CertificateDetailedViewAdapter(mDataset,this);
        RVCertificateView.setAdapter(mAdapter);

        final Button order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(order.getText().toString().equals("অধঃক্রম")){
                    order.setText("উর্ধ্বক্রম");
                    mDataset = (new DBManager(getApplicationContext())).getCertificate(keyname,false);
                }
                else {
                    mDataset = (new DBManager(getApplicationContext())).getCertificate(keyname,true);
                    order.setText("অধঃক্রম");
                }
                mAdapter = new CertificateDetailedViewAdapter(mDataset,getApplicationContext());

                RVCertificateView.setAdapter(null);
                RVCertificateView.setAdapter(mAdapter);
                RVCertificateView.setLayoutManager(certLayoutManager);

            }
        });

    }
}