package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LiveMatch_activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private RecyclerView mrecyclerView2;
    private LiveMatchAdapter madapter;
    private ArrayList<LiveMatchData> mroundList = new ArrayList<>();
    private String url ="https://rest.entitysport.com/v2/matches/?status=3&token=3e0e77298ef32518821a2490c457300c&per_page=50";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_match);
        mroundList = new ArrayList<>();


        bottomNavigationView=findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.live);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.seasons:
                        startActivity(new Intent(getApplicationContext(),season_Activity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.live:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Main_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ranking:
                        startActivity(new Intent(getApplicationContext(),IccRankingActivity.class));
                        overridePendingTransition(0,0);
                        return true;



                }
                return false;
            }
        });
        mrecyclerView2 = findViewById(R.id.roundrecyclerView);
        mrecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView2.setHasFixedSize(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        //back buttons
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        loadData();
    }

    public  void loadData(){
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                pd.dismiss();
                                try {

                                    JSONObject res = response.getJSONObject("response");
                                    JSONArray arr = res.getJSONArray("items");
                                    //Log.i("hoo",arr.toString());
                                    for (int i=0; i < arr.length();i++ ) {

                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String status= jsonObject.getString("status_str");
                                        String match_id = jsonObject.getString("match_id");
                                        JSONObject competition = jsonObject.getJSONObject("competition");
                                        String team_batting = competition.getString("title");
                                        JSONObject teama = jsonObject.getJSONObject("teama");
                                        String  team1 = teama.getString("name");
                                        String team1score= teama.getString("scores_full");
                                         //scor
                                        JSONObject teamb = jsonObject.getJSONObject("teamb");
                                        String team2 = teamb.getString("name");
                                        String team2score= teamb.getString("scores_full");

                                        JSONObject toss = jsonObject.getJSONObject("toss");
                                        String tosswin = toss.getString("text");






                                        mroundList.add(new LiveMatchData(team1, team2, status,team_batting,team1score,team2score,tosswin,match_id));
                                        Log.i("jhdsbfkjsdhjksh", status);
                                    }





                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                madapter = new LiveMatchAdapter(LiveMatch_activity.this,mroundList);
                                mrecyclerView2.setAdapter(madapter);

                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}