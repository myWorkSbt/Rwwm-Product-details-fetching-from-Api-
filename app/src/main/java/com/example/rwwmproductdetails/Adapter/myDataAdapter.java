package com.example.rwwmproductdetails.Adapter;

import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rwwmproductdetails.Model.CategoryDetailsModel.CategoryDetailsResponseModelItem;
import com.example.rwwmproductdetails.Model.DataModel;
import com.example.rwwmproductdetails.Model.FakeApi.FakeApiResponseItem;
import com.example.rwwmproductdetails.R;

import java.util.ArrayList;
import java.util.List;

public class myDataAdapter extends RecyclerView.Adapter<myDataAdapter.myViewHold> {

    public ArrayList<DataModel> mylists;
    public List<FakeApiResponseItem> myFakeDatalists;
    public List<CategoryDetailsResponseModelItem> myCategoryDetails;
    private String itIsFakeApi="";
    public myDataAdapter(ArrayList<DataModel> mylist){
        this.mylists=mylist;
    }
    public myDataAdapter(List<FakeApiResponseItem> myFakeResponseList, String fakeApiStr){
        this.myFakeDatalists= myFakeResponseList;
        this.itIsFakeApi=fakeApiStr;
    }
    public myDataAdapter(String categoryDetailsApistrs, List<CategoryDetailsResponseModelItem> categoryDetailsModel){
        this.myCategoryDetails=categoryDetailsModel;
        this.itIsFakeApi=categoryDetailsApistrs;
    }

    @NonNull
    @Override
    public myViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent, false);
        return new myViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHold holder, int position) {
        if(myFakeDatalists.equals("MyFakeLists")) {
            FakeApiResponseItem fakeApiResponse = myFakeDatalists.get(position);
            holder.tv_product_id.setText(fakeApiResponse.getId() + "");

            holder.product_desc.setText(fakeApiResponse.getUserId() + "");
            holder.tv_product_status.setText(fakeApiResponse.getBody() + "");
            holder.tv_product_slug.setText(fakeApiResponse.getTitle() + "");

        }
        else if(itIsFakeApi=="categoryProductsData"){
            CategoryDetailsResponseModelItem categoryDetailsResponseModelItem= myCategoryDetails.get(position);
            holder.tv_product_id.setText(categoryDetailsResponseModelItem.getId()+"");
            holder.product_desc.setText(categoryDetailsResponseModelItem.getName()+"");
        }
//        else {
//            DataModel mySingleDataElems= mylists.get(position);
//            String Desc_details=mySingleDataElems.getShort_description().replaceAll("<u>","");
//            Desc_details= Desc_details.replaceAll("</u>","");
//            holder.tv_product_id.setText(mySingleDataElems.getId());
//            holder.tv_product_slug.setText("");
//            holder.tv_name.setText(mySingleDataElems.getName());
//            holder.product_desc.setText(Html.fromHtml(Desc_details));
////        holder.product_desc.setText(mySingleDataElems.getShort_description());
//            holder.tv_product_slug.setText( " ");
////        Glide.with(holder.product_img.getContext()).load( Uri.parse(mySingleDataElems.image.getSrc())).into(holder.product_img);
//            holder.tv_product_status.setText("");
//        }

    }

    @Override
    public int getItemCount() {
        if(itIsFakeApi.equals("MyFakeLists")){
            return myFakeDatalists.size();
        }
        else if( itIsFakeApi.equals("categoryProductsData"))
            return myCategoryDetails.size();
        return mylists.size();
    }

    public class myViewHold extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_product_slug,tv_product_id,tv_product_status,product_desc;
        private ImageView product_img;
        public myViewHold(@NonNull View itemView) {
            super(itemView);

            tv_name= (TextView) itemView.findViewById(R.id.product_name);
            tv_product_status= (TextView) itemView.findViewById(R.id.tv_status);
            tv_product_slug= (TextView) itemView.findViewById(R.id.slug_name);
            tv_product_id= (TextView) itemView.findViewById(R.id.product_id);
            product_desc= (TextView) itemView.findViewById(R.id.shorshort_desc_tv);
            product_img= (ImageView) itemView.findViewById(R.id.product_img);
        }
    }
}
