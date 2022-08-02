package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Match_Detail extends AppCompatActivity {
    private String url = "/?token=ec471071441bb2ac538a0ff901abd249&per_page=10&&paged=1";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        //back buttons
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String id3 = intent.getStringExtra("Id");
        Log.i("id:::::", id3);
        url = "https://rest.entitysport.com/v2/" + id3 + url;
        Log.i("link::::::::", url);
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}

