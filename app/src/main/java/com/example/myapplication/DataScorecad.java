
package com.example.myapplication;





public class DataScorecad {
    public static final int TEAMA_LAYOUT = 0;
    public static final int TEAMBBOWLER = 1;
    private int viewType;
    public  int getViewType(){return viewType;}





    private String Scorebatsmenname;
    private String scoreruns;
    private String scoreballs;
    private  String score4s;
    private String score6s;
    private  String scoressr;
    private String howsout;


    public DataScorecad(int viewType,String scorebatsmenname, String scoreruns, String scoreballs, String score4s, String score6s, String scoressr, String howsout) {
        Scorebatsmenname = scorebatsmenname;
        this.scoreruns = scoreruns;
        this.scoreballs = scoreballs;
        this.score4s = score4s;
        this.score6s = score6s;
        this.scoressr = scoressr;
        this.howsout = howsout;
        this.viewType = viewType;
    }

    public String getScoreruns() {
        return scoreruns;
    }

    public String getScoreballs() {
        return scoreballs;
    }


    public String getScorebatsmenname() {
        return Scorebatsmenname;
    }

    public String getScore4s() {
        return score4s;
    }

    public String getScore6s() {
        return score6s;
    }

    public String getScoressr() {
        return scoressr;
    }

    public String getHowsout() {
        return howsout;
    }



    private String bowlername;
    private String overs;
    private String runs;
    private String maiden;
    private String wickets;
    private String economy;


    public DataScorecad( int viewType,String bowlername, String overs, String runs, String maiden, String wickets, String economy) {
        this.bowlername = bowlername;
        this.overs = overs;
        this.runs = runs;
        this.maiden = maiden;
        this.wickets = wickets;
        this.economy = economy;
        this.viewType=viewType;
    }


    //    public Livefragmentdata(int viewType,String bowlername,String overs, String runs, String maiden,String economy) {
//        this.bowlername = bowlername;
//        this.overs = overs;
//        this.runs = runs;
//        this.maiden = maiden;
//        //this.wickets=wickets;
//
//        this.economy = economy;
//        this.viewType =viewType;
//
//    }

    public String getBowlername() {
        return bowlername;
    }

    public String getOvers() {
        return overs;
    }

    public String getRuns() {
        return runs;
    }

    public String getMaiden() {
        return maiden;
    }

    public String getWickets() {return wickets;}
    public String getEconomy(){return economy;}

}


