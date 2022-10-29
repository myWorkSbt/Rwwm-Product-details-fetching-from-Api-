package com.example.rwwmproductdetails.Controller;

import com.example.rwwmproductdetails.Interfaces.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FakeApiClient {

    private static  Retrofit retrofit;
    private static  final String fake_Base_URLs="https://jsonplaceholder.typicode.com/";
    private static FakeApiClient fakeApiClient;
    public FakeApiClient() {
        retrofit= new Retrofit.Builder().baseUrl(fake_Base_URLs)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized FakeApiClient getInstance(){
        if(fakeApiClient== null) {
            fakeApiClient = new FakeApiClient();
        }
        return fakeApiClient;
    }

    public Api getMFakeApi(){
         return retrofit.create(Api.class);
    }
}
