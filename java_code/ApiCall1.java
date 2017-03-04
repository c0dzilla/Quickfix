package com.example.nikhilkaushik.quickfix;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Nikhil Kaushik on 2/5/2017.
 */

public interface ApiCall1 {
    String BASE_URL = "http://52.172.182.38";

    @FormUrlEncoded
    @POST("/query.php")
    Call<Void> SendRequest(@Field("email") String emailid,
                     @Field("date") String date,
                     @Field("title") String title,
                     @Field("brief") String brief,
                     @Field("address") String address);

    class Factory {
        public static ApiCall1 service;

        public static ApiCall1 getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
                service = retrofit.create(ApiCall1.class);
            }
            return service;
        }
    }
}
