package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IccRankingActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icc_ranking);

        bottomNavigationView=findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.ranking);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.seasons:
                        startActivity(new Intent(getApplicationContext(),season_Activity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.ranking:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Main_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.live:
                        startActivity(new Intent(getApplicationContext(),LiveMatch_activity.class));
                        overridePendingTransition(0,0);
                        return true;



                }
                return false;
            }
        });

        Button bt1= findViewById(R.id.teams_rank_id);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="3";
                replacefragment(new Ranking_teams(url));
            }
        });
        Button bt2= findViewById(R.id.batsman_icc_id);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="2";
                replacefragment(new Ranking_teams(url));
            }
        });
        Button bt3= findViewById(R.id.all_rounder_id);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="1";
                replacefragment(new Ranking_teams(url));
            }
        });
        Button bt4= findViewById(R.id.bowler_icc_id);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="0";
                replacefragment(new Ranking_teams(url));
            }
        });

    }
    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_rankings,fragment);
        fragmentTransaction.commit();

    }

}