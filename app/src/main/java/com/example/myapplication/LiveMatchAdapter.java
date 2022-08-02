package com.example.myapplication;

import android.content.Context;
        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

public class LiveMatchAdapter extends RecyclerView.Adapter<LiveMatchAdapter.ViewHolder> {


    private List<LiveMatchData> mroundList;
    private Context mactivity;

    public LiveMatchAdapter(Context context, List<LiveMatchData> roundList) {
        mroundList = roundList;
        mactivity = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mactivity).inflate(R.layout.liveadapter, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveMatchAdapter.ViewHolder holder, int position) {
       LiveMatchData roundList = mroundList.get(position);
        String data = mroundList.get(position).getMteam1();
        String typed = mroundList.get(position).getMteam2();
        String formats = mroundList.get(position).getMstatus();
        String scoreteama = mroundList.get(position).getTeamascore();
        String scoreteamb = mroundList.get(position).getTeambsxcore();
        String  tossdata = mroundList.get(position).getToss();
        String statusdata = mroundList.get(position).getCompition();



        holder.teama.setText(data);
        holder.teamb.setText(typed);
        holder.status.setText(formats);
        holder.teamascore.setText(scoreteama);
        holder.teambscore.setText(scoreteamb);
        holder.toss.setText(tossdata);
        holder.compition.setText(statusdata);


        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String LiveMatch_Url = roundList.getLivematch_url();



                Intent intent = new Intent(mactivity, LiveScoreActivity.class);
                intent.putExtra("LiveMatch_Url",LiveMatch_Url);
                intent.putExtra("data", data);
                intent.putExtra("typed", typed);
                intent.putExtra("formats", formats);
                intent.putExtra("scoreteama", scoreteama);
                intent.putExtra("scoreteamb", scoreteamb);
                intent.putExtra("tossdata",tossdata);
                intent.putExtra("statusdata",statusdata);

                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                mactivity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mroundList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView teama, teamb, status,teamascore,teambscore,toss,compition;
        CardView cd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            teama = itemView.findViewById(R.id.runs);
            teamb = itemView.findViewById(R.id.batsmenname);
            status = itemView.findViewById(R.id.balls);
            teamascore = itemView.findViewById(R.id.fours);
            compition = itemView.findViewById(R.id.status);
 cd = itemView.findViewById(R.id.cd1);
            teambscore = itemView.findViewById(R.id.sixex);
            toss = itemView.findViewById(R.id.toss);

        }

    }
}





