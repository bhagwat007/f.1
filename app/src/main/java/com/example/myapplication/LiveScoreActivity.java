package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class LiveScoreActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView2;
    String iteama;
    String iteamb;
    String icompition;
    String iscoreteama;
    String iscoreteamb;
    String statusdata;
    String Matchid,itossdata;
    private String url ="/live?token=3e0e77298ef32518821a2490c457300cc&per_page=50";
    Button LiveButton,ScoreButton,CommentryButton,PlayerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_score);

        //Button accesss

        LiveButton =findViewById(R.id.button5);
        ScoreButton =findViewById(R.id.button6);
        CommentryButton =findViewById(R.id.button7);
       // PlayerButton =findViewById(R.id.button8);


//back buttons
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //getting data from previous activity

        Intent intent = getIntent();
        Matchid = intent.getStringExtra("LiveMatch_Url");
         iteama = intent.getStringExtra("data");
         iteamb = intent.getStringExtra("typed");
         icompition = intent.getStringExtra("formats");
         iscoreteama = intent.getStringExtra("scoreteama");
         iscoreteamb = intent.getStringExtra("scoreteamb");
         itossdata = intent.getStringExtra("tossdata");
         statusdata = intent.getStringExtra("statusdata");
        Log.i("id:::::", Matchid);
//Add match id to url
        url = "https://rest.entitysport.com/v2/matches/" + Matchid + url;
        Log.i("link::::::::", url);


//onclick to button  for fragment replacement
        LiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new LiveFragment());
            }
        });
        ScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new ScoreFragment());
            }
        });
        CommentryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replacefragment(new PlayingXIFragment(Matchid,iteama,iteamb));
            }
        });
//        PlayerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                replacefragment(new P());
//
//
//            }
//        });
    }

    //for passing data to fragment

    public String getteamadata() {
        return iteama;
    }
    public String getteambdata() {
        return iteamb;
    }
    public String getcompitiondata() {
        return icompition;
    }
    public String getteamascoredata() {
        return iscoreteama;
    }
    public String getteambscore() {
        return iscoreteamb;
    }
    public String gettossdata() {
        return itossdata;
    }
    public String getmatchiddata() {
        return Matchid;
    }
    public String getStatusdata() {
        return statusdata;
    }


    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();


    }



    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}