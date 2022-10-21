package com.example.rwwmproductdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.rwwmproductdetails.Adapter.myDataAdapter;
import com.example.rwwmproductdetails.Controller.RwwmClient;
import com.example.rwwmproductdetails.Model.DataModel;
import com.example.rwwmproductdetails.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        mainBinding.recyclerView.setLayoutManager(layoutManager);

        Call<ArrayList<DataModel>> call=RwwmClient.getInstance().getApi().getProductData();
        call.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                if(response.isSuccessful() && response!=null) {
                    ArrayList<DataModel> myResponseLists= response.body();
                    myDataAdapter adapter= new myDataAdapter(myResponseLists);
                    mainBinding.recyclerView.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Response Getted from api ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, " myResponses: "+response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, " Response Failed :"+t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}