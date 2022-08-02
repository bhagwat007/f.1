package com.example.myapplication;





public class LiveMatchData {
    private String mteam1;
    private String mteam2;
    private String mstatus;
    private  String teamascore;
    private String teambsxcore;
private  String toss;
private String compition;
private String livematch_url;
    public LiveMatchData(String teama, String teamb,String compition, String status, String teamascore, String teambsxcore, String toss,String livematch_url) {
        mteam1 = teama;
        mteam2 = teamb;
        this.compition=compition;
        mstatus = status;
        this.teamascore = teamascore;
        this.teambsxcore = teambsxcore;
        this.toss=toss;
        this.livematch_url=livematch_url;




    }

    public String getCompition() {
        return compition;
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

//    public String getMdateend() {
//        return mdateend;
//    }


    public String getToss() {
        return toss;
    }

    public String getLivematch_url() {
        return livematch_url;
    }
}


