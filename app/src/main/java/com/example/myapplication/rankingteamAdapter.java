package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rankingteamAdapter extends RecyclerView.Adapter<rankingteamAdapter.ViewHolder> {
    public ArrayList<player_raniking> item = new ArrayList();
    public Context applicationContext;
    public rankingteamAdapter(ArrayList<player_raniking> listArray, Context applicationContext) {
        this.item=listArray;
        this.applicationContext=applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout7, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        player_raniking temp=item.get(position);
        holder.rank_icc.setText(temp.rank);
        holder.icc_name.setText(temp.team);
        holder.icc_rating.setText(temp.points);
        holder.icc_point.setText(temp.rating);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rank_icc;
        public TextView icc_name;
        public TextView icc_rating;
        public TextView icc_point;
        public ViewHolder(View view) {
            super(view);
            rank_icc=itemView.findViewById(R.id.icc_ranks);
            icc_name=itemView.findViewById(R.id.team_name_idd);
            icc_rating=itemView.findViewById(R.id.team_rating);
            icc_point=itemView.findViewById(R.id.team_points);
        }
    }
}
