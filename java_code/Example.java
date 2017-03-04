package com.example.nikhilkaushik.quickfix;

/**
 * Created by Nikhil Kaushik on 2/6/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("response")
    @Expose
    private List<Request> request = null;

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }
}

