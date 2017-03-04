package com.example.nikhilkaushik.quickfix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public class allrequest {

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

    @SerializedName("id")
    @Expose
    private int id;



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

    public allrequest(String title, String brief, String date, String address,int id) {
        this.title = title;
        this.brief = brief;
        this.date = date;
        this.address = address;
        this.id=id;
    }

    public int getId() {

        return  id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


