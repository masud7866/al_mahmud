package com.ieitlabs.masud.almahmud;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setTitle("আমাদের কথা");

        WebView webView = findViewById(R.id.about);
        WebSettings settings = webView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        webView.loadUrl("file:///android_asset/about_text.html");

        Button family = findViewById(R.id.family);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SolaimanLipi_20-04-07.ttf");
        family.setTypeface(custom_font);
        family.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutActivity.this,FamilyActivity.class);
                AboutActivity.this.startActivity(intent);
            }
        });
    }

}
