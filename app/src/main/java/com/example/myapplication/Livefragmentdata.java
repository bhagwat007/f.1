package com.example.myapplication;





public class Livefragmentdata {

    public static final int BATSME_LAYOUT = 0;
    public static final int BOWLER_LAYOUT=1;
    public static final int COMENTRY_LAYOUT=2;

    private int viewType;
    public  int getViewType(){return viewType;}





    private String mteam1;
    private String mteam2;
    private String mstatus;
    private  String teamascore;
    private String teambsxcore;
    private  String toss;
    public Livefragmentdata (int viewType,String teama, String teamb, String status, String teamascore, String teambsxcore, String toss) {
        mteam1 = teama;
        mteam2 = teamb;
        mstatus = status;
        this.teamascore = teamascore;
        this.teambsxcore = teambsxcore;
        this.toss=toss;
        this.viewType =viewType;




    }

    public String getMteam1() {
        return mteam1;
    }
    public String getMteam2() {
        return mteam2;
    }

    public String getMstatus() {
        return mstatus;
    }

    public String getTeamascore() {
        return teamascore;
    }

    public String getTeambsxcore() {
        return teambsxcore;
    }



    public String getToss() {
        return toss;
    }

    //for bowler
    private String bowlername;
    private String overs;
    private String runs;
    private String maiden;
    private String wickets;
    private String economy;
    private String id;
    public Livefragmentdata(int viewType,String bowlername,String overs, String runs, String maiden,String wickets,String economy,String id) {
        this.bowlername = bowlername;
        this.overs = overs;

        this.runs = runs;
        this.maiden = maiden;
        this.wickets = wickets;
        this.economy = economy;
        this.id = id;
        this.viewType =viewType;

    }

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

    public String getEconomy() {
        return economy;
    }
    public String getId() {
        return id;
    }
    //boeler

    //for comentry
    private String commentryRuns;
    private String commentry;
    private  String extra;

    public Livefragmentdata(int viewType,String commentryRuns, String commentry, String extra) {
        this.commentryRuns = commentryRuns;
        this.commentry = commentry;
        this.extra = extra;
        this.viewType = viewType;
    }


    public String getCommentryRuns() {
        return commentryRuns;
    }



    public String getCommentry() {
        return commentry;
    }
    public String getExtra() {
        return extra;
    }
    //commentry
}