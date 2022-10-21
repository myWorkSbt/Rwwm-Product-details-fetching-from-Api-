package com.example.rwwmproductdetails.Interfaces;

import com.example.rwwmproductdetails.Model.DataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("custom_api")
    Call<ArrayList<DataModel>> getProductData();

}
