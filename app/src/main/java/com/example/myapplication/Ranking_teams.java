package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Ranking_teams extends Fragment implements View.OnClickListener {

    View view;
    public String format="?";
    public Ranking_teams(String url) {
        this.format=url;
    }
    public String type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_diff_teams, container, false);
        Button bt1= view.findViewById(R.id.odi_ranking);
        bt1.setOnClickListener(this);
        Button bt2= view.findViewById(R.id.test_ranking);
        bt2.setOnClickListener(this);
        Button bt3= view.findViewById(R.id.t20_ranking);
        bt3.setOnClickListener(this);
        return view;
}
    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_top10,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.odi_ranking:
                type="0";
                break;
            case R.id.test_ranking:
                type="1";
                break;
            case R.id.t20_ranking:
                type="2";
                break;
        }
        Log.i("kshdgjhsgd::::::",type);
        replacefragment(new top_lists(type, format));
    }
}