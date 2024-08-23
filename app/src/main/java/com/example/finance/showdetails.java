package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class showdetails extends AppCompatActivity {
    WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetails);

        webview=findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("file:///android_asset/users.html");
        WebSettings websettings = webview.getSettings();
        websettings.setJavaScriptEnabled(true);

        }
    }
