package com.ieitlabs.masud.almahmud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle("আমাদের কথা");

        WebView webView = findViewById(R.id.about);
        webView.loadUrl("file:///android_asset/about_text.html");
    }

}
