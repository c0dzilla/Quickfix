package com.example.nikhilkaushik.quickfix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public class Messages {


    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("acc_email")
    @Expose
    private String acc_email;

    public Messages(String title , String acc_email) {
        this.title = title;
        this.acc_email=acc_email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAcc_email() {
        return acc_email;
    }

    public void setAcc_email(String acc_email) {
        this.acc_email = acc_email;
    }





}
