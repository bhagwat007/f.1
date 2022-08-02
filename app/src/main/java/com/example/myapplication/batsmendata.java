package com.example.myapplication;

public class batsmendata {
    public static final int BATSME_LAYOUT = 0;
    public static final int BOWLER_LAYOUT=1;
    public static final int COMENTRY_LAYOUT=2;

    private int viewType;
    public  int getViewType(){return viewType;}


    private String bowlername;
    private String overs;
    private String runs;
    private String maiden;
    private String wickets;
    private String economy;

    public batsmendata(int viewType,String bowlername,String overs, String runs, String maiden,String wickets,String economy) {
        this.bowlername = bowlername;
        this.overs = overs;
        this.runs = runs;
        this.maiden = maiden;
        this.wickets = wickets;
        this.economy = economy;
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

//    public String getWickets() {
//        return wickets;
//    }

    public String getEconomy() {
        return economy;
    }
}
