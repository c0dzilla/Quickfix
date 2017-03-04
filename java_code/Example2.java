package com.example.nikhilkaushik.quickfix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public class Example2 {
    @SerializedName("messages")
    @Expose
    private List<Messages> Messages = null;

    public List<Messages> getRequest() {
        return Messages;
    }

    public void setRequest(List<Messages> Messages) {
        this.Messages = Messages;
    }


}
