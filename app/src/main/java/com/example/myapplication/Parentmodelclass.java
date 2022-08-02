package com.example.myapplication;

import java.util.ArrayList;

public class Parentmodelclass {
    String title;
    ArrayList<CompletedMatchData> mroundlist;

    public Parentmodelclass(String title, ArrayList<CompletedMatchData> mroundlist) {
        this.title = title;
        this.mroundlist = mroundlist;
    }

}
