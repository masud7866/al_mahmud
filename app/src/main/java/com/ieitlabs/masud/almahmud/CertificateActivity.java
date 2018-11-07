package com.ieitlabs.masud.almahmud;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import java.util.LinkedHashMap;

public class CertificateActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);

        setTitle("হাদীসের সনদ");
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setSubtitle(Html.fromHtml("<small>দাওরায়ে হাদিস, জামিয়া ইসলামিয়া দারুল উলূম মাদানিয়া, যাত্রাবাড়ী, ঢাকা</small>"));

        LinkedHashMap<String,String> mDataset = new LinkedHashMap<>();
        mDataset.put("abu_daud_1","আবু দাউদ ১ম");
        mDataset.put("abu_daud_2","আবু দাউদ ২য়");
        mDataset.put("bukhari_1","বুখারী ১ম");
        mDataset.put("bukhari_2","বুখারী ২য়");
        mDataset.put("ibne_majah","ইবনে মাজাহ");
        mDataset.put("muatta_malek","মুয়াত্তা মালেক");
        mDataset.put("muatta_muhammad","মুয়াত্তা মুহাম্মাদ");
        mDataset.put("muslim_1","মুসলিম ১ম");
        mDataset.put("muslim_2","মুসলিম ২য়");
        mDataset.put("nasai","নাসাঈ");
        mDataset.put("shamayele_tirmiji","শামায়েলে তিরমিযী");
        mDataset.put("tirmiji_1","তিরমিযী ১ম");
        mDataset.put("tirmiji_2_1","তিরমিযী ২য় (প্রথমাংশ)");
        mDataset.put("tirmiji_2_2","তিরমিযী ২য়");
        mDataset.put("twahabi","ত্বহাবী");
        RecyclerView RVCertificateView = findViewById(R.id.certificate_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        RVCertificateView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager certLayoutManager = new LinearLayoutManager(this);
        RVCertificateView.setLayoutManager(certLayoutManager);

        // specify an adapter (see also next example)
        CertificateViewAdapter mAdapter;
        mAdapter = new CertificateViewAdapter(mDataset,this);
        RVCertificateView.setAdapter(mAdapter);


    }
}
