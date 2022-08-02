package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class compitionAdapter extends RecyclerView.Adapter<compitionAdapter.ViewHolder> {
    private List<Datalist> mdataList;
    private Context mcontext;
    public compitionAdapter(Context context, List<Datalist> dataList) {
        mdataList = dataList;
        mcontext = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view1 = LayoutInflater.from(mcontext).inflate(R.layout.compitionlist,parent,false);
        return new ViewHolder(view1);
    }
    @Override
    public void onBindViewHolder(@NonNull compitionAdapter.ViewHolder holder, int position) {
        Datalist datalist = mdataList.get(position);
        String titledata = mdataList.get(position).getTitle();
        String abbrdata = mdataList.get(position).getMabbr();
        String startdatedata = mdataList.get(position).getMstartDate();
        String enddatedata = mdataList.get(position).getMendDate();

        holder.name.setText(titledata);
        holder.abbr.setText(abbrdata);
        holder.startDate.setText(startdatedata);
        holder.endDate.setText(enddatedata);
        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Match_Url = datalist.getMseason();
                Intent intent = new Intent(mcontext, match_Activity.class);
                intent.putExtra("Match_Url", Match_Url);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return mdataList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name,abbr,startDate,endDate;
        CardView cardView;
        Button btn1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView1);
            abbr = itemView.findViewById(R.id.abbr);
            startDate = itemView.findViewById(R.id.startdate);
            endDate = itemView.findViewById(R.id.endDate);
            cardView = itemView.findViewById(R.id.card2);
            btn1 = itemView.findViewById(R.id.Cmatches);
        }
    }
}
