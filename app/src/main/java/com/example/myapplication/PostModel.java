package com.example.myapplication;

//package com.example.recyclerview;

public class PostModel {
    private String mname;

    //get compition_url (getter method)

    private String compition_url;
    public PostModel(String name, String compition_url) {
        mname = name;
        this.compition_url = compition_url;
    }
    public String getCompition_url() {
        return compition_url;
    }

    public String getName() {
        return mname;
    }

}

