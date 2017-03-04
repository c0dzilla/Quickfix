package com.example.nikhilkaushik.quickfix;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Nikhil Kaushik on 2/4/2017.
 */

public interface ApiCall2 {

    String BASE_URL = "http://52.172.182.38";

    @FormUrlEncoded
    @POST("/response.php")
    Call<Void> Login(@Field("email")String emailid);

    class Factory {
        public static ApiCall2 service;

        public static ApiCall2 getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
                service = retrofit.create(ApiCall2.class);
            }
            return service;
        }
    }
}