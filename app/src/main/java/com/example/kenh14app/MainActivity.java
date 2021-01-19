package com.example.kenh14app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    ListView lstTinTuc;
    Response response;
    OkHttpClient client;
    okhttp3.Request request;
    String content;
    TinTuc tinTuc;
    WifiBroadcastReceiver wifiBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        lstTinTuc = findViewById(R.id.lstTinTuc);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        wifiBroadcastReceiver = new WifiBroadcastReceiver();

        client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "secret_key=FcSLmHfbgnLVWUVw%$#@A9DkKnqAJsHv");
        request = new okhttp3.Request.Builder().url("https://p2.cnnd.vn/kenh14-api/app/lastest-news-paging")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try {
            response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            content = responseBody.string();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tinTuc = new TinTuc();
        Gson gson = new Gson();
        try {
            tinTuc = gson.fromJson(content, TinTuc.class);
            if (tinTuc.getNews() == null){
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Thông báo");
                alert.setMessage("Không lên?");
            }
            else {
                lstTinTuc.setAdapter(new MyAdapter(MainActivity.this, tinTuc.getNews()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }

        lstTinTuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DocTinTuc.class);
                intent.putExtra("url", tinTuc.getUrl(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(wifiBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiBroadcastReceiver);
    }
}
