package com.example.nikhilkaushik.quickfix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public class Example1 {

    @SerializedName("allrequest")
    @Expose
    private List<allrequest> allrequest = null;

    public List<allrequest> getRequest() {
        return allrequest;
    }

    public void setRequest(List<allrequest> allrequest) {
        this.allrequest = allrequest;
    }

}

