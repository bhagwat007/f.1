package com.example.myapplication;

public class Datalist {
    private String mtitle;
    private String mabbr;
    private String mstartDate;
    private String mendDate;
    private String mseason;
    public Datalist(String name,String abbr , String startdate , String enddate, String season) {
        mtitle = name;
        mabbr = abbr;
        mstartDate = startdate;
        mendDate = enddate;
        mseason = season;
    }


    public String getMabbr() {
        return mabbr;
    }

    public String getMstartDate() {
        return mstartDate;
    }

    public String getMendDate() {
        return mendDate;
    }

    public String getTitle() {
        return mtitle;
    }

    public String getMseason() {
        return mseason;
    }

}
