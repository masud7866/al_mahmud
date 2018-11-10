package com.ieitlabs.masud.almahmud;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        setTitle("আল মাহমুদ পরিবার");

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");

        for(int i = 0; i < myToolbar.getChildCount(); i++) {
            View view = myToolbar.getChildAt(i);
            if(view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setTypeface(custom_font);
            }
        }

        WebView webView = findViewById(R.id.family);
        WebSettings settings = webView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        webView.loadUrl("file:///android_asset/family_text.html");
    }
}
