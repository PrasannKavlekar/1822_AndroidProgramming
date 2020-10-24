package com.skywalkr.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    String path1 = "https://www.youtube.com";
    String path2 = "file:///android_asset/noInternet.html";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = findViewById(R.id.wView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl(path1);
        if (!netConnection.verifyNet(this)) {
            webView.loadUrl(path2);
        } else {
            webView.loadUrl(path1);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.reloadbtn) {
            Intent refresh = new Intent(this,MainActivity.class);
            startActivity(refresh);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}