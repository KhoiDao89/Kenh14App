package com.example.kenh14app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DocTinTuc extends AppCompatActivity {

    WebView wbvTinTuc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tintuc);
        wbvTinTuc = findViewById(R.id.wbvTinTuc);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        wbvTinTuc.loadUrl("https://kenh14.vn"+url);
        wbvTinTuc.setWebViewClient(new WebViewClient());
        wbvTinTuc.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void applyOverrideConfiguration(final Configuration overrideConfiguration) {
        if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 25) {
            overrideConfiguration.uiMode &= ~Configuration.UI_MODE_NIGHT_MASK;
        }
        super.applyOverrideConfiguration(overrideConfiguration);
    }
}
