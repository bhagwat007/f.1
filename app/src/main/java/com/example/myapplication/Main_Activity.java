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
import android.view.View;
import android.widget.Button;

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

public class Main_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private RecyclerView mrecyclerView2,mrecyclerView12;
    private LiveMatchAdapter madapter;
    private ArrayList<Parentmodelclass> mroundList2 = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundLis = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList1 = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList3 = new ArrayList<>();
    private ArrayList<CompletedMatchData> mroundList4 = new ArrayList<>();

    private String url = "https://rest.entitysport.com/v2/matches/?status=3&token=3e0e77298ef32518821a2490c457300c&per_page=50";


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mroundLis = new ArrayList<>();
        mroundList = new ArrayList<>();
        mroundList1 = new ArrayList<>();
        mroundList2 = new ArrayList<>();
        mroundList4 = new ArrayList<>();
        mroundList3 = new ArrayList<>();


        getSupportActionBar().hide();


        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.seasons:
                        startActivity(new Intent(getApplicationContext(), season_Activity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.live:
                        startActivity(new Intent(getApplicationContext(), LiveMatch_activity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;

                    case R.id.ranking:
                        startActivity(new Intent(getApplicationContext(), IccRankingActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;


                }
                return false;
            }
        });

        //Button season = (Button) findViewById(R.id.button3);
        //season.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //public void onClick(View view) {
        //  Intent numbersIntent = new Intent(Main_Activity.this, season_Activity.class);
        //  startActivity(numbersIntent);

        // }
        // });
        /*Button Live = (Button) findViewById(R.id.button4);
        Live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Main_Activity.this, LiveMatch_activity.class);
                startActivity(numbersIntent);

            }
        });
        Button Ranking = (Button) findViewById(R.id.Ranking);
        Ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Activity.this, IccRankingActivity.class);
                startActivity(intent);

            }
        });*/
//        Button match = (Button) findViewById(R.id.matches);
//        match.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                replacefragment(new CompletedFragment());
//            }
//        });

//        mrecyclerView12 = findViewById(R.id.liverecycle);
//        mrecyclerView12.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        mrecyclerView12.setHasFixedSize(true);

        mrecyclerView2  = findViewById(R.id.mrecycle);
        mrecyclerView2.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView2.setHasFixedSize(true);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("SportsEntity");


        loadData();
        completedmatchData();

       // scheduledmatchesdtaa();


    }

    public void loadData() {
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
                                    for (int i = 0; i < arr.length(); i++) {

                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String domestic = jsonObject.getString("domestic");
                                            String status = jsonObject.getString("status_str");
                                            String match_id = jsonObject.getString("match_id");
                                            JSONObject competition = jsonObject.getJSONObject("competition");
                                            String team_batting = competition.getString("title");
                                            JSONObject teama = jsonObject.getJSONObject("teama");
                                            String team1 = teama.getString("name");
                                            String team1score = teama.getString("scores_full");
                                            //scor
                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
                                            String team2 = teamb.getString("name");
                                            String team2score = teamb.getString("scores_full");

                                            JSONObject toss = jsonObject.getJSONObject("toss");
                                            String tosswin = toss.getString("text");


                                            mroundLis.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));
                                            Log.i("jhdsbfkjsdhjksh", status);
                                        }

                                    mroundList2.add(new Parentmodelclass("Live(International)",mroundLis));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                ParentAdapter livefragmentAdapter = new ParentAdapter(Main_Activity.this, mroundList2);
                                mrecyclerView2.setAdapter(livefragmentAdapter);
                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);
    }
    public void completedmatchData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, "https://rest.entitysport.com/v2/matches/?status=2&token=3e0e77298ef32518821a2490c457300c&per_page=150", null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    JSONObject res = response.getJSONObject("response");
                                    JSONArray arr = res.getJSONArray("items");
                                    //Log.i("hoo",arr.toString());
                                    for (int i = 0; i < arr.length(); i++) {

                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String domestic = jsonObject.getString("domestic");
                                        if (domestic.equals("0")) {
                                            String match_id = jsonObject.getString("match_id");
                                            JSONObject competition = jsonObject.getJSONObject("competition");
                                            String team_batting = competition.getString("title");
                                            JSONObject teama = jsonObject.getJSONObject("teama");
                                            String team1 = teama.getString("name");
                                            String team1score = teama.getString("scores_full");
                                            String status = jsonObject.getString("status_str");
                                            //scor
                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
                                            String team2 = teamb.getString("name");
                                            String team2score = teamb.getString("scores_full");

                                            //JSONObject toss = jsonObject.getJSONObject("toss");
                                            String tosswin = jsonObject.getString("status_note");

                                            mroundList1.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));

//                                            Log.i("jhdsbfkjsdhjksh", category);
                                        }
                                    }
                                    mroundList2.add(new Parentmodelclass("International(Completed)",mroundList1));



                                    //Log.i("hoo",arr.toString());
                                    for (int i = 0; i < arr.length(); i++) {

                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String domestic = jsonObject.getString("domestic");
                                        if (domestic.equals("1")) {
                                            String match_id = jsonObject.getString("match_id");
                                            JSONObject competition = jsonObject.getJSONObject("competition");
                                            String team_batting = competition.getString("title");
                                            JSONObject teama = jsonObject.getJSONObject("teama");
                                            String team1 = teama.getString("name");
                                            String team1score = teama.getString("scores_full");
                                            String status = jsonObject.getString("status_str");
                                            //scor
                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
                                            String team2 = teamb.getString("name");
                                            String team2score = teamb.getString("scores_full");

                                            //JSONObject toss = jsonObject.getJSONObject("toss");
                                            String tosswin = jsonObject.getString("status_note");

                                            mroundList3.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));

//                                            Log.i("jhdsbfkjsdhjksh", category);
                                        }
                                    }

                                    mroundList2.add(new Parentmodelclass("Domestic(Completed)",mroundList3));


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                ParentAdapter livefragmentAdapter = new ParentAdapter(Main_Activity.this, mroundList2);
                                mrecyclerView2.setAdapter(livefragmentAdapter);

//                                madapter = new LiveMatchAdapter(getActivity().getApplicationContext(),mroundList);
//                                mrecyclerView2.setAdapter(madapter);

                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);
    }
//    public  void scheduledmatchesdtaa(){
//        ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("Loading...");
//        pd.show();
//        RequestQueue queue = Volley.newRequestQueue(this);
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                (Request.Method.GET, "https://rest.entitysport.com/v2/matches/?status=1&token=3e0e77298ef32518821a2490c457300c&per_page=150", null,
//                        new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                pd.dismiss();
//                                try {
//
//                                    JSONObject res = response.getJSONObject("response");
//                                    JSONArray arr = res.getJSONArray("items");
//                                    //Log.i("hoo",arr.toString());
//                                    for (int i=0; i < arr.length();i++ ) {
//
//                                        JSONObject jsonObject = arr.getJSONObject(i);
//                                        String domestic = jsonObject.getString("domestic");
//                                        if (domestic.equals("0")) {
//                                            String title = jsonObject.getString("title");
//                                            String match_id = jsonObject.getString("match_id");
//                                            JSONObject competition = jsonObject.getJSONObject("competition");
//                                            String team_batting = competition.getString("title");
//                                            JSONObject teama = jsonObject.getJSONObject("teama");
//                                            String team1 = teama.getString("name");
//                                            String team1score = teama.getString("short_name");
//                                            String status = jsonObject.getString("status_str");
//                                            //scor
//                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
//                                            String team2 = teamb.getString("name");
//                                            String team2score = teamb.getString("short_name");
//
//                                            JSONObject toss = jsonObject.getJSONObject("venue");
//                                            String tosswin = toss.getString("name");
//
//
//                                            mroundList.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));
//
//                                            Log.i("jhdsbfkjsdhjksh", match_id);
//                                        }
//                                    }
//                                    mroundList2.add(new Parentmodelclass("International(Scheduled)", mroundList));
//
//                                    for (int i = 0; i < arr.length(); i++) {
//                                        JSONObject jsonObject = arr.getJSONObject(i);
//                                        String domestic = jsonObject.getString("domestic");
//                                        if (domestic.equals("1")) {
//                                            String title = jsonObject.getString("title");
//                                            String match_id = jsonObject.getString("match_id");
//                                            JSONObject competition = jsonObject.getJSONObject("competition");
//                                            String team_batting = competition.getString("title");
//                                            JSONObject teama = jsonObject.getJSONObject("teama");
//                                            String team1 = teama.getString("name");
//                                            String team1score = teama.getString("short_name");
//                                            String status = jsonObject.getString("status_str");
//                                            //scor
//                                            JSONObject teamb = jsonObject.getJSONObject("teamb");
//                                            String team2 = teamb.getString("name");
//                                            String team2score = teamb.getString("short_name");
//
//                                            JSONObject toss = jsonObject.getJSONObject("venue");
//                                            String tosswin = toss.getString("name");
//
//
//                                            mroundList4.add(new CompletedMatchData(team1, team2, status, team_batting, team1score, team2score, tosswin, match_id));
//
//                                            Log.i("jhdsbfkjsdhjksh", match_id);
//                                        }
//                                    }
//                                    mroundList2.add(new Parentmodelclass("Domestic(Scheduled)",mroundList4));
//
//
//
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                                ParentAdapter livefragmentAdapter = new ParentAdapter(Main_Activity.this, mroundList2);
//                                mrecyclerView2.setAdapter(livefragmentAdapter);
//                            }
//
//                        }, error -> {
//                });
//        queue.add(jsonObjectRequest);
//    }
}
