package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class top_lists extends Fragment {
    public String type = "?";
    public String format = "?";
    public ArrayList<player_raniking> listArray = new ArrayList<player_raniking>();
    public RecyclerView recyclerView;
    public rankingteamAdapter mAdapter;
    public Context mContext;
    private Object JsonObjectRequest;
    public top_lists(String type, String format) {
        this.type = type;
        this.format=format;
    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_top_lists, container, false);
        recyclerView= view.findViewById(R.id.fr_icc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.i("kshdgjhsgd::::::",type);
        start();
        return view;
    }

    public  void start()
    {

        RequestQueue queue = Volley.newRequestQueue(view.getContext());
        String url="https://rest.entitysport.com/v2/iccranks?token=3e0e77298ef32518821a2490c457300c&per_page=50";
        com.android.volley.toolbox.JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    JSONObject res = response.getJSONObject("response");
                                    JSONObject temp = res.getJSONObject("ranks");
                                    JSONObject per = null;
                                    if(format=="2") {
                                        per = temp.getJSONObject("batsmen");
                                        if (type == "0") {
                                            JSONArray bowl = per.getJSONArray("odis");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "1") {
                                            JSONArray bowl = per.getJSONArray("tests");
                                            Log.i("boelerLenght>>>",bowl.toString());
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "2") {
                                            JSONArray bowl = per.getJSONArray("t20s");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");
                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                    }
                                    if(format=="0") {
                                        per = temp.getJSONObject("bowlers");
                                        if (type == "0") {
                                            JSONArray bowl = per.getJSONArray("odis");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "1") {
                                            JSONArray bowl = per.getJSONArray("tests");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "2") {
                                            JSONArray bowl = per.getJSONArray("t20s");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");
                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                    }
                                    if(format=="1") {
                                        per = temp.getJSONObject("all-rounders");

                                        if (type == "0") {
                                            JSONArray bowl = per.getJSONArray("odis");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "1") {
                                            JSONArray bowl = per.getJSONArray("tests");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "2") {
                                            JSONArray bowl = per.getJSONArray("t20s");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("player");
                                                String points_icc = obj.getString("team");
                                                String rating_icc = obj.getString("rating");
                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                    }
                                    if(format=="3") {
                                        per = temp.getJSONObject("teams");
                                        if (type == "0") {
                                            JSONArray bowl = per.getJSONArray("odis");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");

                                                String team_icc = obj.getString("team");
                                                String points_icc = obj.getString("points");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "1") {
                                            JSONArray bowl = per.getJSONArray("tests");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("team");
                                                String points_icc = obj.getString("points");
                                                String rating_icc = obj.getString("rating");

                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                        if (type == "2") {
                                            JSONArray bowl = per.getJSONArray("t20s");
                                            for (int i = 0; i < bowl.length(); i++) {
                                                JSONObject obj = bowl.getJSONObject(i);
                                                String rank_icc = obj.getString("rank");
                                                String team_icc = obj.getString("team");
                                                String points_icc = obj.getString("points");
                                                String rating_icc = obj.getString("rating");
                                                player_raniking rasp = new player_raniking(rank_icc, team_icc, points_icc, rating_icc);
                                                listArray.add(rasp);
                                            }
                                        }
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                mAdapter = new rankingteamAdapter(listArray, view.getContext().getApplicationContext());
                                recyclerView.setAdapter(mAdapter);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });
        queue.add(jsonObjectRequest);
    }
}