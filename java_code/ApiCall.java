package com.example.nikhilkaushik.quickfix;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Nikhil Kaushik on 2/4/2017.
 */

public interface ApiCall {

    String BASE_URL = "http://52.172.182.38";

    @FormUrlEncoded
    @POST("/main.php")
    Call<Void> Signup(@Field("user")String user,
                       @Field("email")String m,
                       @Field("city") String c,
                       @Field("work") String r);

    class Factory {
        public static ApiCall service;

        public static ApiCall getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
                service = retrofit.create(ApiCall.class);
            }
            return service;
        }
    }
}
