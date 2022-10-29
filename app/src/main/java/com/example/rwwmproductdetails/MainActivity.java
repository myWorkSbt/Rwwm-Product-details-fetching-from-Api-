package com.example.rwwmproductdetails;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.rwwmproductdetails.Adapter.myDataAdapter;
import com.example.rwwmproductdetails.Controller.CategoryDetailsController;
import com.example.rwwmproductdetails.Controller.FakeApiClient;
import com.example.rwwmproductdetails.Controller.RwwmClient;
import com.example.rwwmproductdetails.Model.CategoryDetailsModel.CategoryDetailsResponseModelItem;
import com.example.rwwmproductdetails.Model.DataModel;
import com.example.rwwmproductdetails.Model.FakeApi.FakeApiResponseItem;
import com.example.rwwmproductdetails.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private int current_items,scrollOut_items_postions,total_items;
    private LinearLayoutManager layoutManager;
    private Boolean isScrolling= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        mainBinding.recyclerView.setLayoutManager(layoutManager);

        mainBinding.progressBar.setVisibility(View.VISIBLE);

//
//        getAnotherApiData();
//

        getFakeApiDataAndSettingIt();
//
//        getCategoryDetails();

//        mainBinding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if(newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
//                    isScrolling=true;
//                }
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                    current_items= layoutManager.getChildCount();
//                    total_items= layoutManager.getItemCount();
//                    scrollOut_items_postions=layoutManager.findFirstCompletelyVisibleItemPosition();
//                    if(isScrolling && ( current_items + scrollOut_items_postions == total_items)){
//                        // data Fetch
//                        isScrolling=false;
//                        fetchDataOfPerPage();
//                    }
//            }
//        });
    }

    private void getCategoryDetails() {

        Call<List<CategoryDetailsResponseModelItem>> call=CategoryDetailsController.getInstance().getCategorApis().getCategoryApi();
        call.enqueue(new Callback<List<CategoryDetailsResponseModelItem>>() {
            @Override
            public void onResponse(Call<List<CategoryDetailsResponseModelItem>> call, Response<List<CategoryDetailsResponseModelItem>> response) {
                if(response.isSuccessful() && response!=null ){
                    List<CategoryDetailsResponseModelItem> categoryDetailsResponseModelItemList= response.body();
                    myDataAdapter dataAdapter= new myDataAdapter("categoryProductsData", categoryDetailsResponseModelItemList);
                    mainBinding.recyclerView.setAdapter(dataAdapter);
                    Toast.makeText(MainActivity.this, "Response Getted from api ", Toast.LENGTH_SHORT).show();
                    mainBinding.progressBar.setVisibility(View.INVISIBLE);
                }
                else {
                    Toast.makeText(MainActivity.this, " myResponses: "+response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CategoryDetailsResponseModelItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, " onResponse "+ t.getMessage() , Toast.LENGTH_SHORT).show();
                Log.d(TAG, "CategoryDetailsData-------   onFailure: "+ t.getMessage());
            }
        });
    }

    private void getFakeApiDataAndSettingIt() {
        Call<List<FakeApiResponseItem>> call= FakeApiClient.getInstance().getMFakeApi().getFakeApiDtas();
        call.enqueue(new Callback<List<FakeApiResponseItem>>() {
            @Override
            public void onResponse(Call<List<FakeApiResponseItem>> call, Response<List<FakeApiResponseItem>> response) {
                if(response.isSuccessful() && response!= null){
                    List<FakeApiResponseItem> fakeApiResponseItems=response.body();
                    myDataAdapter adapter = new myDataAdapter(fakeApiResponseItems, "MyFakeLists");
                    mainBinding.recyclerView.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Response Getted from api ", Toast.LENGTH_SHORT).show();
                    mainBinding.progressBar.setVisibility(View.INVISIBLE);
                }
                else {
                    Toast.makeText(MainActivity.this, " myResponses: "+response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FakeApiResponseItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, " Failure is : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG,   "FakeApi -----onFailure:  "+ t.getMessage());
            }
        });


    }
//
//    private void getAnotherApiData() {
//        Call<ArrayList<DataModel>> call= RwwmClient.getInstance().getApi().getProductData();
//        call.enqueue(new Callback<ArrayList<DataModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
//                if(response.isSuccessful() && response!=null) {
//                    ArrayList<DataModel> myResponseLists= response.body();
//                    myDataAdapter adapter = new myDataAdapter(myResponseLists);
//                    mainBinding.recyclerView.setAdapter(adapter);
//                    Toast.makeText(MainActivity.this, "Response Getted from api ", Toast.LENGTH_SHORT).show();
//                    mainBinding.progressBar.setVisibility(View.INVISIBLE);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, " myResponses: "+response, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, " Response Failed :"+t.getMessage().toString(), Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "AnotherApi   -onFailure:  "+t.getMessage());
//            }
//        });
//
//    }
//

}