package com.example.rwwmproductdetails.Controller;

import com.example.rwwmproductdetails.Interfaces.Api;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryDetailsController {


    private static Retrofit retrofit;
    private static final String Category_Base_URL="https://raviworldwidemedicines.com/";
    private static CategoryDetailsController categoryDetailsController=null;

    public CategoryDetailsController() {
        retrofit= new Retrofit.Builder().baseUrl(Category_Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized CategoryDetailsController getInstance() {
        if (categoryDetailsController== null){
            categoryDetailsController= new CategoryDetailsController();
        }
        return categoryDetailsController;
    }


    public Api getCategorApis() {
        return retrofit.create(Api.class);
    }

}
