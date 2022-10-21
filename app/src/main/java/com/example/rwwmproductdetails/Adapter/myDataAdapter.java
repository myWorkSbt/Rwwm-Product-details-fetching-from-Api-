package com.example.rwwmproductdetails.Adapter;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rwwmproductdetails.Model.DataModel;
import com.example.rwwmproductdetails.R;

import java.util.ArrayList;

public class myDataAdapter extends RecyclerView.Adapter<myDataAdapter.myViewHold> {

    public ArrayList<DataModel> mylists;
    public myDataAdapter(ArrayList<DataModel> mylist){
        this.mylists=mylist;
    }
    @NonNull
    @Override
    public myViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent, false);
        return new myViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHold holder, int position) {
        DataModel mySingleDataElems= mylists.get(position);
        holder.tv_product_id.setText(mySingleDataElems.getId());
        holder.tv_product_slug.setText(mySingleDataElems.getSlug());
        holder.tv_name.setText(mySingleDataElems.getName());
        holder.product_desc.setText(Html.fromHtml(mySingleDataElems.getShort_description()));
        holder.tv_product_slug.setText(mySingleDataElems.getStatus());
    }

    @Override
    public int getItemCount() {
        return mylists.size();
    }

    public class myViewHold extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_product_slug,tv_product_id,tv_product_status,product_desc;
        public myViewHold(@NonNull View itemView) {
            super(itemView);

            tv_name= (TextView) itemView.findViewById(R.id.product_name);
            tv_product_status= (TextView) itemView.findViewById(R.id.tv_status);
            tv_product_slug= (TextView) itemView.findViewById(R.id.slug_name);
            tv_product_id= (TextView) itemView.findViewById(R.id.product_id);
            product_desc= (TextView) itemView.findViewById(R.id.shorshort_desc_tv);
        }
    }
}
