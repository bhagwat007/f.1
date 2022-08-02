package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LivefragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int BATSME_LAYOUT = 0;
    public static final int BOWLER_LAYOUT=1;
    public static final int COMENTRY_LAYOUT=2;
    public static final int BOWLER_NAME=3;


    private ArrayList<Livefragmentdata> mroundList;


    public LivefragmentAdapter(ArrayList<Livefragmentdata> roundList) {
        mroundList = roundList;



    }

    @Override
    public int getItemViewType(int position) {

        switch (mroundList.get(position).getViewType()){

            case 0:
                return BATSME_LAYOUT;
            case 1:
                return BOWLER_LAYOUT;
            case 2:
                return COMENTRY_LAYOUT;
            case 3:
                return BOWLER_NAME;
            default:
                return -1;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case BATSME_LAYOUT:
                View batsmen_layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.batsmenlayout, null);
                return new Batsmenlayout(batsmen_layout);

            case BOWLER_LAYOUT:
                View bowler_layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.bowler_layout, null);
                return new BowlerLayout(bowler_layout);


            case COMENTRY_LAYOUT:
                View commentry_layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.commentry_layout, null);
                return new CommentryLayout(commentry_layout);

            default:
                return null;
        }

        //   View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.batsmenlayout, null);


        //return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // LiveMatchData roundList = mroundList.get(position);
        switch (mroundList.get(position).getViewType()){
            case BATSME_LAYOUT:
                Batsmenlayout batsmenlayoutholder = (Batsmenlayout) holder;
                String data = mroundList.get(position).getMteam1();
                String typed = mroundList.get(position).getMteam2();
                String formats = mroundList.get(position).getMstatus();
                String scoreteama = mroundList.get(position).getTeamascore();
                String scoreteamb = mroundList.get(position).getTeambsxcore();
                String  tossdata = mroundList.get(position).getToss();



                batsmenlayoutholder.teama.setText(data);
                batsmenlayoutholder.teamb.setText(typed);
                batsmenlayoutholder.status.setText(formats);
                batsmenlayoutholder.teamascore.setText(scoreteama);
                batsmenlayoutholder.teambscore.setText(scoreteamb);
                batsmenlayoutholder.toss.setText(tossdata);



                break;

            case BOWLER_LAYOUT:
                BowlerLayout bowlerlayoutholder = (BowlerLayout) holder;

                String bowlernamedata = mroundList.get(position).getBowlername();
                String bowlerrunsdata = mroundList.get(position).getRuns();
                String bowleroverdata = mroundList.get(position).getOvers();
                String bowlerwicketsdata = mroundList.get(position).getMaiden();
                String bowlerecodata = mroundList.get(position).getWickets();
                String  ecomdata = mroundList.get(position).getEconomy();
                String  id = mroundList.get(position).getEconomy();



                bowlerlayoutholder.bowlername.setText(bowlernamedata);
                bowlerlayoutholder.bowlerruns.setText(bowlerrunsdata);
                bowlerlayoutholder.bowlerover.setText(bowleroverdata);
                bowlerlayoutholder.bowlerwickets.setText(bowlerwicketsdata);
                bowlerlayoutholder.bowlerecnomy.setText(bowlerecodata);
                bowlerlayoutholder.bowlermaiden.setText(ecomdata);


                break;

            case COMENTRY_LAYOUT:
                CommentryLayout commentryLayoutholder =(CommentryLayout)holder;
                String data2 = mroundList.get(position).getCommentryRuns();
                String typed2 = mroundList.get(position).getCommentry();
                String formats2 = mroundList.get(position).getExtra();



                commentryLayoutholder.commentryRuns.setText(data2);
                commentryLayoutholder.commentry.setText(typed2);
                commentryLayoutholder.extra.setText(formats2);

                break;

            default:
                return;
        }
//        String data = mroundList.get(position).getMteam1();
//        String typed = mroundList.get(position).getMteam2();
//        String formats = mroundList.get(position).getMstatus();
//        String scoreteama = mroundList.get(position).getTeamascore();
//        String scoreteamb = mroundList.get(position).getTeambsxcore();
//        String  tossdata = mroundList.get(position).getToss();
//
//
//
//        holder.teama.setText(data);
//        holder.teamb.setText(typed);
//        holder.status.setText(formats);
//        holder.teamascore.setText(scoreteama);
//        holder.teambscore.setText(scoreteamb);
//        holder.toss.setText(tossdata);



//        holder.teama.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //String Match_Url = roundList.getMatch_url();
//
//                Intent intent = new Intent(mactivity, LiveScoreActivity.class);
//                // intent.putExtra("Match_Url", Match_Url);
//                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
////                mactivity.startActivity(intent);
//
//            }
//        });
//
    }

    @Override
    public int getItemCount() {
        return mroundList.size();
    }


    public class Batsmenlayout extends RecyclerView.ViewHolder {
        public TextView teama, teamb, status,teamascore,teambscore,toss;

        public Batsmenlayout(@NonNull View itemView) {
            super(itemView);

            teama = itemView.findViewById(R.id.batsmenname);
            teamb = itemView.findViewById(R.id.runs);
            status = itemView.findViewById(R.id.balls);
            teamascore = itemView.findViewById(R.id.fours);

            teambscore = itemView.findViewById(R.id.sixex);
            toss = itemView.findViewById(R.id.strikerate);


        }

    }
    public class BowlerLayout extends RecyclerView.ViewHolder {
        public TextView bowlername, bowlerruns, bowlerover,bowlerwickets,bowlerecnomy,bowlermaiden;

        public BowlerLayout(@NonNull View itemView) {
            super(itemView);

            bowlername = itemView.findViewById(R.id.commentrybowlername);
            bowlerruns = itemView.findViewById(R.id.commentrybowlerruns);
            bowlerover = itemView.findViewById(R.id.livebowlerovers);
            bowlerwickets = itemView.findViewById(R.id.livebowlerwickets);
            bowlermaiden= itemView.findViewById(R.id.bowler_maiden);

            bowlerecnomy = itemView.findViewById(R.id.livebowlereconmy);
            //toss = itemView.findViewById(R.id.strikerate);


        }

    }
    public class CommentryLayout extends RecyclerView.ViewHolder {
        public TextView commentryRuns, commentry, extra;

        public CommentryLayout(@NonNull View itemView) {
            super(itemView);

            commentryRuns = itemView.findViewById(R.id.commentry_Runs);
            commentry = itemView.findViewById(R.id.commentry);
            extra = itemView.findViewById(R.id.commentryover);


        }

    }
//    public class BOwlername extends RecyclerView.ViewHolder {
//        public TextView commentryRuns, commentry, extra;
//
//        public BOwlername(@NonNull View itemView) {
//            super(itemView);
//
//            commentryRuns = itemView.findViewById(R.id.commentry_Runs);
//            commentry = itemView.findViewById(R.id.commentry);
//            extra = itemView.findViewById(R.id.commentryover);
//
//
//        }

//    }


}