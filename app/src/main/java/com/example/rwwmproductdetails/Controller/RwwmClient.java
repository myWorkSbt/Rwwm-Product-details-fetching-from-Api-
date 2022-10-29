package com.example.rwwmproductdetails.Controller;

import com.example.rwwmproductdetails.Interfaces.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RwwmClient {
    private static final String Rwwm_Client_UrlS="https://raviworldwidemedicines.com/";
    private static Retrofit retrofit;
    private static RwwmClient rwwmClient;

    public RwwmClient () {
        retrofit= new Retrofit.Builder().baseUrl(Rwwm_Client_UrlS)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
    }

    public  static  synchronized  RwwmClient getInstance() {
        if(rwwmClient==null){
            rwwmClient= new RwwmClient();
        }
        return rwwmClient;
    }

    public static Api getApi() {

        return retrofit.create(Api.class);
    }
}
