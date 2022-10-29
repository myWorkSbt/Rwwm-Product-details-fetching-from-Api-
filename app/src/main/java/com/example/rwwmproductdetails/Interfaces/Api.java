package com.example.rwwmproductdetails.Interfaces;

import com.example.rwwmproductdetails.Model.CategoryDetailsModel.CategoryDetailsResponseModelItem;
import com.example.rwwmproductdetails.Model.DataModel;
import com.example.rwwmproductdetails.Model.FakeApi.FakeApiResponseItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("custom_api")
    Call<ArrayList<DataModel>> getProductData();

    @GET("posts")
    Call<List<FakeApiResponseItem>> getFakeApiDtas();

    @GET("custom_api/get_all_category.php")
    Call<List<CategoryDetailsResponseModelItem>> getCategoryApi();

}
