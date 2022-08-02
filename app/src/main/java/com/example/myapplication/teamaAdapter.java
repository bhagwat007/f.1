package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class teamaAdapter extends RecyclerView.Adapter<teamaAdapter.ViewHolder> {
    private ArrayList<playing11> item = new ArrayList();
    public Context applicationContext;
    public teamaAdapter(ArrayList<playing11> item, Context applicationContext) {
        this.item = item;
        this.applicationContext=applicationContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout6, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        playing11 temp=item.get(position);
        holder.p_name.setText(temp.player_name);
//        holder.playerid.setText(temp.player_id);

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        public TextView p_name,playerid;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            p_name=itemView.findViewById(R.id.player_11_id);
        }
    }
}
