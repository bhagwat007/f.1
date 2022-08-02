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

public class ScoreFragment extends Fragment {
    String matchid;
    String inninganame,teamascore,inningbname,teambscore;
    ArrayList<DataScorecad> mroundList = new ArrayList<>();
    //private String url1 ="https://rest.entitysport.com/v2/matches/?status=3&token=3e0e77298ef32518821a2490c457300c&per_page=50";
    String url;
    private String toke = "/scorecard?token=3e0e77298ef32518821a2490c457300c&per_page=150";

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_score, container, false);
        LiveScoreActivity activity = (LiveScoreActivity) getActivity();

        //LiveScoreActivity activity = (LiveScoreActivity) view.getContext();
        matchid = activity.getmatchiddata();
        Log.i("matchid::::", matchid);
        url = "https://rest.entitysport.com/v2/matches/" + matchid + toke;
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

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
                                    JSONObject inning_object = innings.getJSONObject(0);
                                    TextView text2= (TextView) view.findViewById(R.id.edit);
                                    text2.setText(title);
                                    String inninganame =inning_object.getString("name");
                                    TextView teama = (TextView) view.findViewById(R.id.btn1);
                                    teama.setText(inninganame);
                                    Log.i("name:::::",inninganame);
                                    String teamascoredata = inning_object.getString("scores_full");
                                    TextView teamascore = (TextView) view.findViewById(R.id.scoreteama);
                                    teamascore.setText(teamascoredata);
                                    JSONObject inningb_object = innings.getJSONObject(1);
                                    String inningbname = inningb_object.getString("name");
                                    TextView teamb = (TextView) view.findViewById(R.id.btn2);
                                    teamb.setText(inningbname);
                                    String teambscoredata = inningb_object.getString("scores_full");
                                    TextView teambscore = (TextView) view.findViewById(R.id.scoreteamb);
                                    teambscore.setText(teambscoredata);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);
        TextView text = (TextView) view.findViewById(R.id.btn1);
        text.setText(teamascore);
        TextView text1 = (TextView) view.findViewById(R.id.btn2);

        String batsmendata = "kjdshls";
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorecard fragment = new scorecard();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment);
                fragmentTransaction.commit();
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teambScorecard fragment1 = new teambScorecard();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment1);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
//    public void loadapi(){
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null,
//                        new Response.Listener<JSONObject>() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                try {
//
//                                    JSONObject res = response.getJSONObject("response");
//                                    String title = res.getString("title");
//                                    Log.i("jhghv>>>::::",title);
//                                    JSONArray innings = res.getJSONArray("innings");
//                                    JSONObject inning_object = innings.getJSONObject(0);
//                                    String inninganame =inning_object.getString("name");
//                                    Log.i("name:::::",inninganame);
//                                    String teamascore = inning_object.getString("scores_full");
//                                    JSONObject inningb_object = innings.getJSONObject(1);
//                                    String inningbname = inning_object.getString("name");
//                                    String teambscore = inning_object.getString("score_full");
//
//                                    TextView text = (TextView)  view.findViewById(R.id.btn1);
//                                   text.setText(inninganame);
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//
//                        }, error -> {
//                });
//        queue.add(jsonObjectRequest);
//
//    }
                                }
//
