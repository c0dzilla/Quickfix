package com.example.nikhilkaushik.quickfix;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public interface ApiGet1 {

    String BASE_URL = "http://52.172.182.38";

    @GET("/allrequest.php")
    Call<Example1> getRequest(@Query("email") String emailid);

    class Factory {
        public static ApiGet1 service;

        public static ApiGet1 getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
                service = retrofit.create(ApiGet1.class);
            }
            return service;
        }
    }

}
