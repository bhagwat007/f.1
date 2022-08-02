

package com.example.myapplication;


        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.ActionBar;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

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

public class season_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private RecyclerView mrecyclerView;
    private PostAdapter madapter;
    private ArrayList<PostModel> mpostList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);
        mpostList = new ArrayList<>();


        bottomNavigationView=findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.seasons);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Main_Activity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.seasons:
                        return true;

                    case R.id.live:
                        startActivity(new Intent(getApplicationContext(),LiveMatch_activity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ranking:
                        startActivity(new Intent(getApplicationContext(), IccRankingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;



                }
                return false;
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Season");
        //back buttons
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        //call recycleview
        mrecyclerView = findViewById(R.id.recyclerView);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setHasFixedSize(true);
        start();
    }
    public void  start() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://rest.entitysport.com/v2/seasons/?token=3e0e77298ef32518821a2490c457300c&per_page=50";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                pd.dismiss();
                                try {
                                    //for jsonobject
                                    JSONObject res = response.getJSONObject("response");
                                    //For array in API
                                    JSONArray arr = res.getJSONArray("items");
                                    for (int i= arr.length()-1; i >0 ;i--) {
                                        JSONObject jsonObject = arr.getJSONObject(i);
                                        String name = jsonObject.getString("name");
                                        String competitions_url = jsonObject.getString("competitions_url");
                                        mpostList.add(new PostModel(name,competitions_url));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                //call Adapter
                                madapter = new PostAdapter(season_Activity.this,mpostList);
                                mrecyclerView.setAdapter(madapter);
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