package com.example.nikhilkaushik.quickfix;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Nikhil Kaushik on 2/7/2017.
 */

public interface ApiCall3 {

    String BASE_URL = "http://52.172.182.38";

    @FormUrlEncoded
    @POST("/accept.php")
    Call<Void>  accept(@Field("id")String id,@Field("email")String email);

    class Factory {
        public static ApiCall3 service;

        public static ApiCall3 getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
                service = retrofit.create(ApiCall3.class);
            }
            return service;
        }
    }

}
