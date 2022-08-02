package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;




    public class teambScorecard extends Fragment {
        String matchid;
        RecyclerView mrecyclerView2;
        ArrayList<DataScorecad> mroundList = new ArrayList<>();
        String url;
        private String toke ="/scorecard?token=3e0e77298ef32518821a2490c457300c&per_page=50";


        View view;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            LiveScoreActivity activity = (LiveScoreActivity) getActivity();
            matchid = activity.getmatchiddata();
            url = "https://rest.entitysport.com/v2/matches/" + matchid + toke;
            Log.i("gfhghgfgf::;;",url);
            // Inflate the layout for this fragment
            mroundList.add(new DataScorecad( 0,"Batsmen", "R","B","4","6","S.sr",""));

            view = inflater.inflate(R.layout.fragment_teamb_scorecard, container, false);
            loadscoredata();
            return view;

        }
        public void loadscoredata(){
            ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading...");
            progressDialog.show();


            mrecyclerView2 = view.findViewById(R.id.rj2);
            mrecyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
            mrecyclerView2.setHasFixedSize(true);


            RequestQueue queue = Volley.newRequestQueue(getContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    progressDialog.dismiss();
                                    try {

                                        JSONObject res = response.getJSONObject("response");
                                        String title = res.getString("title");
                                        Log.i("jhghv>>>::::",title);
                                        JSONArray innings = res.getJSONArray("innings");
                                        JSONObject inning_object = innings.getJSONObject(1);
                                        String inningname =inning_object.getString("name");
                                        Log.i("name:::::",inningname);
                                        JSONArray batsmen = inning_object.getJSONArray("batsmen");
                                        for (int k=0;k<batsmen.length();k++) {
                                            JSONObject batsmendetails = batsmen.getJSONObject(k);

                                            String tbatsmen = batsmendetails.getString("name");
                                            Log.i("batsment",tbatsmen);
                                            Log.i("batsmentname:::",tbatsmen);
                                            String batsmen_runs = batsmendetails.getString("runs");
                                            String ball_faced = batsmendetails.getString("balls_faced");
                                            String out = batsmendetails.getString("how_out");
                                            String sfour = batsmendetails.getString("fours");
                                            String ssixes = batsmendetails.getString("sixes");

                                            String sssr = batsmendetails.getString("strike_rate");

                                            Log.i("howoutheid",out);

                                            mroundList.add(new DataScorecad( 0,tbatsmen, batsmen_runs,ball_faced,sfour,ssixes,sssr,out));
                                            Log.i("jhdsbfkjsdhjksh", out);
                                        }
                                        mroundList.add(new DataScorecad( 1,"Bowler", "R","B","4","6","S.sr"));

                                        JSONArray bowller = inning_object.getJSONArray("bowlers");
                                        for (int m=0;m<bowller.length();m++)
                                        {
                                            JSONObject bowlerdetail = bowller.getJSONObject(m);
                                            String bowlername  = bowlerdetail.getString("name");
                                            String bowlerid = bowlerdetail.getString("bowler_id");
                                            String bowlerRuns  = bowlerdetail.getString("runs_conceded");
                                            String bowlerover  = bowlerdetail.getString("overs");
                                            String bowlermaidian  = bowlerdetail.getString("maidens");
                                            String eco  = bowlerdetail.getString("econ");
                                            String bowlerwickets  = bowlerdetail.getString("wickets");
                                            mroundList.add(new DataScorecad( 1,bowlername, bowlerover,bowlerRuns,bowlermaidian,bowlerwickets,eco));

                                        }



                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    teambscorecardadapter  livefragmentAdapter = new teambscorecardadapter(getActivity().getApplicationContext(),mroundList);
                                    mrecyclerView2.setAdapter(livefragmentAdapter);
                                }

                            }, error -> {
                    });
            queue.add(jsonObjectRequest);
            // mroundList.add(new DataScorecad( 1,"tbatsmen","ball_faced","sfour","ssixes","sssr","out"));

        }
    }