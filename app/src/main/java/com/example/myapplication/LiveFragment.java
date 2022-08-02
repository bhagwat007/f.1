package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveFragment extends Fragment {
    public LiveFragment(){

    }
    //LivefragmentAdapter madapter;
    public static final int BOWLER_LAYOUT =1;
    public static final int COMENTRY_LAYOUT=2;
    ArrayList<Livefragmentdata> mroundList = new ArrayList<>();
    ArrayList<batsmendata> batsmendataArrayList=new ArrayList<>();
    //String url ="https://rest.entitysport.com/v2/matches/?status=3&token=3e0e77298ef32518821a2490c457300c&per_page=50";
    String url ="/live?token=3e0e77298ef32518821a2490c457300c&per_page=150";
    String curl ="/innings/1/commentary?token=3e0e77298ef32518821a2490c457300c&per_page=1500";

    RecyclerView mrecyclerView2;
    //    TextView Compition, Tossdata,liveteama,liveteamb,liveteamascore,liveteambscore;
//    TextView bowler,over,maiden,runs,wickets,economy;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LiveScoreActivity activity = (LiveScoreActivity) getActivity();
        String teamdata = activity.getteamadata();
        String teambscoredata = activity.getteambscore();
        String compitiondata = activity.getcompitiondata();
        String teamascoredata = activity.getteamascoredata();
        String teambdata = activity.getteambdata();
        String toaadata = activity.gettossdata();
        String Match_url = activity.getmatchiddata();
        String statusdata = activity.getStatusdata();


        Log.i("hhgajhgjhakhja::::{{{{}}}}}}",teamascoredata);
        view = inflater.inflate(R.layout.fragment_live, container, false);
        TextView Compition = (TextView) view.findViewById(R.id.Compition);
        TextView Teama = (TextView) view.findViewById(R.id.liveteama);
        TextView teamb = (TextView) view.findViewById(R.id.liveteamb);
        TextView scoreteama = (TextView) view.findViewById(R.id.livescoreteama);
        TextView scoreteamb = (TextView) view.findViewById(R.id.livescoreteamb);
        TextView status = (TextView) view.findViewById(R.id.Status);
        TextView tossdata = (TextView) view.findViewById(R.id.Tossdata);


        Compition.setText(compitiondata);
        Teama.setText(teamdata);
        teamb.setText(teambdata);
        scoreteama.setText(teamascoredata);
        scoreteamb.setText(teambscoredata);
        status.setText(statusdata);
        tossdata.setText(toaadata);

        mrecyclerView2 = view.findViewById(R.id.recyclerview_Livescore);
        mrecyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        mrecyclerView2.setHasFixedSize(true);


        mroundList.add(new Livefragmentdata(0,"Batsmen","R","B","4's","6's","Ssr"));
//
//        mroundList.add(new Livefragmentdata(COMENTRY_LAYOUT,"lkjajh","jlsdh","sdlkjh","lksjd","jhdgs","jgf"));
//        LivefragmentAdapter  livefragmentAdapter = new LivefragmentAdapter(mroundList);
//        mrecyclerView2.setAdapter(livefragmentAdapter);

//        mroundList = new ArrayList<>();

        url = "https://rest.entitysport.com/v2/matches/" + Match_url + url;
        curl = "https://rest.entitysport.com/v2/matches/" + Match_url + curl;
        Log.i("url:::>>>>",url);

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("loading...");
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
                                    JSONArray batsmens = res.getJSONArray("batsmen");
                                    for (int i = 0; i < batsmens.length(); i++) {
                                        JSONObject batsmen_object = batsmens.getJSONObject(i);
                                        String tbatsmen = batsmen_object.getString("name");
                                        String batsmen_runs = batsmen_object.getString("runs");
                                        String ball_faced = batsmen_object.getString("balls_faced");
                                        String fours = batsmen_object.getString("fours");
                                        String sixes = batsmen_object.getString("sixes");
                                        String strike_rate = batsmen_object.getString("strike_rate");
                                        mroundList.add(new Livefragmentdata(0, tbatsmen, batsmen_runs, ball_faced, fours, sixes, strike_rate));
                                        Log.i("jhdsbfkjsdhjksh", sixes);

                                    }
                                    JSONArray boelers = res.getJSONArray("bowlers");

                                    JSONObject bowler_object = boelers.getJSONObject(0);
                                    String bowler_name = bowler_object.getString("name");
                                    Log.i("bowler_name:::", bowler_name);
                                    String ball_overs = bowler_object.getString("overs");
                                    String bowler_runs = bowler_object.getString("runs_conceded");
                                    String bowler_maiden = bowler_object.getString("maidens");
                                    String bowler_wickets = bowler_object.getString("wickets");
                                    String bowler_economy = bowler_object.getString("econ");
                                    mroundList.add(new Livefragmentdata(1, "Bowler", "O", "R", "W", "Eco", "M", ""));
                                    mroundList.add(new Livefragmentdata(1, bowler_name, ball_overs, bowler_runs, bowler_wickets, bowler_economy, bowler_maiden, ""));

                                    JSONObject bowler_object1 = boelers.getJSONObject(1);
                                    String bowler_name1 = bowler_object1.getString("name");
                                    Log.i("bowler_name:::", bowler_name);
                                    String ball_overs1 = bowler_object1.getString("overs");
                                    String bowler_runs1 = bowler_object1.getString("runs_conceded");
                                    String bowler_maiden1 = bowler_object1.getString("maidens");
                                    String bowler_wickets1 = bowler_object1.getString("wickets");
                                    String bowler_economy1 = bowler_object1.getString("econ");
                                    mroundList.add(new Livefragmentdata(1, bowler_name1, ball_overs1, bowler_runs1, bowler_wickets1, bowler_economy1, bowler_maiden1, ""));




                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                LivefragmentAdapter  livefragmentAdapter = new LivefragmentAdapter(mroundList);
                                mrecyclerView2.setAdapter(livefragmentAdapter);


                            }

                        }, error -> {
                });
        queue.add(jsonObjectRequest);






        ProgressDialog progressDialog2 = new ProgressDialog(getContext());
        progressDialog2.setMessage("Loading...");
        progressDialog2.show();

        RequestQueue queue2 = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest
                (Request.Method.GET, curl, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                progressDialog2.dismiss();
                                try {

                                    JSONObject res = response.getJSONObject("response");

                                    JSONArray comentryarray = res.getJSONArray("commentaries");

                                    for (int k=comentryarray.length()-1;k>0;k--)
                                    {
                                        JSONObject commentryobject = comentryarray.getJSONObject(k);
                                        String commentryruns = commentryobject.getString("score");

                                        String commentarystats = commentryobject.getString("commentary");
                                        Log.i("overss::",commentryruns);
                                        String commentryovers = commentryobject.getString("over");
                                        Log.i("bowler_name:::",commentryovers);
                                        mroundList.add(new Livefragmentdata(COMENTRY_LAYOUT,commentryruns,commentarystats,commentryovers));

                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                LivefragmentAdapter  livefragmentAdapter = new LivefragmentAdapter(mroundList);
                                mrecyclerView2.setAdapter(livefragmentAdapter);;

                            }

                        }, error -> {
                });
        queue2.add(jsonObjectRequest2);



        return view;

    }


}