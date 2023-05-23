package com.example.mobileapp_programming_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutPage extends AppCompatActivity {

    private WebView aboutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        aboutView = findViewById(R.id.webView);
        aboutView.setWebViewClient(new WebViewClient());
        aboutView.getSettings().setJavaScriptEnabled(true);
        aboutView.loadUrl("file:///android_asset/about.html");

    }



}