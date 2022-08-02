package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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


public class PlayingXIFragment extends Fragment {
    View view;
    public String id="";
    public String team_1,team_2;
    ArrayList<playing11> listArray = new ArrayList<playing11>();
    ArrayList<playing11> listArray1 = new ArrayList<playing11>();
    public String toke="/squads?token=3e0e77298ef32518821a2490c457300c";
    public RecyclerView recyclerView,recyclerView1;
    public teamaAdapter mAdapter;

    public PlayingXIFragment(String string, String team_1, String team_2) {
        this.id=string;
        this.team_1=team_1;
        this.team_2=team_2;
    }

    public String url;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_playingxi, container, false);
        recyclerView= view.findViewById(R.id.teama);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView1= view.findViewById(R.id.teamb);
        recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
        TextView t1= view.findViewById(R.id.team_2_id);
        TextView t2= view.findViewById(R.id.team_1_id);
        t1.setText(team_2);
        t2.setText(team_1);
        Log.i("kshdgjhsgd::::::",id);
        url="https://rest.entitysport.com/v2/matches/"+id+toke;
        Log.i("kshdgjhsgd::::::",url);
        start();
        run();
        return view;
    }
    public  void run()
    {

        RequestQueue queue = Volley.newRequestQueue(view.getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String s1="true";

                                    JSONObject res = response.getJSONObject("response");
                                    JSONObject team=res.getJSONObject("teamb");
                                    String ar1r = team.getString("team_id");
                                    JSONArray arr = team.getJSONArray("squads");
                                    Log.i("gf>>>>",ar1r);
                                    for (int i = 0; i < arr.length(); i++) {
                                        JSONObject obj = arr.getJSONObject(i);
                                        String player_name = obj.getString("name");
                                       // Log.i("mane::",player_name);
                                        String playing= obj.getString("playing11");
                                        String player_id = obj.getString("player_id");
                                        if(playing.equals(s1)) {
                                            playing11 rasp = new playing11(player_name,player_id);
                                          //  Log.i("kshdgjhsgd::::::",player_name );
                                            listArray.add(rasp);
                                        }

                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                mAdapter=new teamaAdapter(listArray,view.getContext().getApplicationContext());
                                recyclerView1.setAdapter(mAdapter);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });
        queue.add(jsonObjectRequest);
    }
    public  void start()
    {

        RequestQueue queue = Volley.newRequestQueue(view.getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    String s1="true";

                                    JSONObject res = response.getJSONObject("response");
                                    JSONObject team=res.getJSONObject("teama");
                                    String ar1r = team.getString("team_id");
Log.i("kjkhj",ar1r);
                                    JSONArray arr = team.getJSONArray("squads");
                                    for (int i = 0; i < arr.length(); i++) {
                                        JSONObject obj = arr.getJSONObject(i);
                                        String player_name = obj.getString("name");
                                        String playing= obj.getString("playing11");
                                        String player_id = obj.getString("player_id");
                                        if(playing.equals(s1)) {
                                            playing11 rasp = new playing11(player_name,player_id);
                                            Log.i("kshdgjhsgd::::::",player_name );
                                            listArray1.add(rasp);
                                       }

                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                mAdapter=new teamaAdapter(listArray1,view.getContext().getApplicationContext());
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