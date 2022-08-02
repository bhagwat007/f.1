
package com.example.myapplication;

        import android.content.Context;
        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

public class ScorecardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<DataScorecad> mroundList;
    private Context mactivity;

    public ScorecardAdapter(Context context,List<DataScorecad> roundList) {
        mroundList = roundList;
        mactivity = context;

    }

    @Override
    public int getItemViewType(int position) {

        switch (mroundList.get(position).getViewType()){
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return -1;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case 0:
                View batsmen_layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.scorecard, null);
                return new TeamBatsmenlayout(batsmen_layout);

            case 1:
                View bowler_layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.bowlerscorecard, null);
                return new TeamBowlerLayout(bowler_layout);


            default:
                return null;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (mroundList.get(position).getViewType()) {
            case 0:

                TeamBatsmenlayout batsmenlayoutholder = (TeamBatsmenlayout) holder;
                //String data = mroundList.get(position).getMteam1();
                String data = mroundList.get(position).getScorebatsmenname();
                String typed = mroundList.get(position).getScoreruns();
                String formats = mroundList.get(position).getScoreballs();
                String score4sdata = mroundList.get(position).getScore4s();
                String score6sdata = mroundList.get(position).getScore6s();
                String scoreessr = mroundList.get(position).getScoressr();
                String statusdata = mroundList.get(position).getHowsout();


                batsmenlayoutholder.scorebatsmenname.setText(data);
                batsmenlayoutholder.scorreruns.setText(typed);
                batsmenlayoutholder.scoreballs.setText(formats);
                batsmenlayoutholder.score4s.setText(score4sdata);
                batsmenlayoutholder.score6s.setText(score6sdata);
                batsmenlayoutholder.scoressr.setText(scoreessr);
                batsmenlayoutholder.scoreout.setText(statusdata);


                break;

            case 1:
                TeamBowlerLayout bowlerlayoutholder = (TeamBowlerLayout) holder;
                String bowlernamedata = mroundList.get(position).getBowlername();
                String bowlerruns = mroundList.get(position).getRuns();
                String bowlerovers = mroundList.get(position).getOvers();
                String bowlerwickets = mroundList.get(position).getWickets();
                String bowlereco = mroundList.get(position).getEconomy();
                String bowleemaiden = mroundList.get(position).getMaiden();


                bowlerlayoutholder.bowlername.setText(bowlernamedata);
                bowlerlayoutholder.runs.setText(bowlerruns);
                bowlerlayoutholder.over.setText(bowlerovers);
                bowlerlayoutholder.wickets.setText(bowlerwickets);
                bowlerlayoutholder.economy.setText(bowlereco);
                bowlerlayoutholder.maiden.setText(bowleemaiden);
                break;

            default:
                return;

        }
    }

    @Override
    public int getItemCount() {
        return mroundList.size();
    }


    public class TeamBatsmenlayout extends RecyclerView.ViewHolder {
        public TextView scorebatsmenname, scorreruns, scoreout,scoreballs,score4s,score6s,scoressr;

        public TeamBatsmenlayout(@NonNull View itemView) {
            super(itemView);

            scoreout = itemView.findViewById(R.id.scoreout);
            scorreruns = itemView.findViewById(R.id.scoreruns);
            scorebatsmenname = itemView.findViewById(R.id.scorebatsmenname);
            scoreballs = itemView.findViewById(R.id.scoreballs);
            score4s = itemView.findViewById(R.id.score4s);
            score6s = itemView.findViewById(R.id.scpre6s);
            scoressr = itemView.findViewById(R.id.scoressr);


        }

    }
        public class TeamBowlerLayout extends RecyclerView.ViewHolder {
            public TextView bowlername, wickets, runs,over,economy,maiden;

            public TeamBowlerLayout(@NonNull View itemView) {
                super(itemView);

                wickets = itemView.findViewById(R.id.bowlerwickets);
                runs = itemView.findViewById(R.id.bowlerruns);
                bowlername = itemView.findViewById(R.id.bowlername);
                over = itemView.findViewById(R.id.bowlerovers);
                economy = itemView.findViewById(R.id.bowlereco);
                maiden = itemView.findViewById(R.id.bowlermaiden);



            }

        }

}





