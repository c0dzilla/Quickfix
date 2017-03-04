package com.example.nikhilkaushik.quickfix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Kaushik on 2/6/2017.
 */

public class Request {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("brief")
    @Expose
    private String brief;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("address")
    @Expose
    private String address;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Request(String title, String brief, String date, String address) {
        this.title = title;
        this.brief = brief;
        this.date = date;
        this.address = address;
    }
}