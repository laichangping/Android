package com.lab.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //获得浏览器webView控件
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        //得到鼠标点击之后的intent
        Intent intent = getIntent();
        Uri uri = intent.getData();//获取data属性
        String urlString = null;
        try {
            urlString = new URL(uri.getScheme(), uri.getHost(), uri.getPath()).toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        webView.loadUrl(urlString);//加载
        //手机默认浏览器打开，为了通过WebView打开网页，设置
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url.startsWith("http:") || url.startsWith("https:")){
                    view.loadUrl(url);
                    return false;
                }
                view.loadUrl(url);
                return true;
            }
        });
    }
}
