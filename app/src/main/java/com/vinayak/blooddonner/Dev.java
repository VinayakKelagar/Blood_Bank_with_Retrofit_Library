package com.vinayak.blooddonner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Dev extends AppCompatActivity {

WebView wv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);

        wv4 = (WebView) findViewById(R.id.wv_news_four);

        wv4.loadUrl("https://vinayakkelagar7.github.io/p1/");
    }
}