package com.example.zingotv.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private JSONData jsonData;
    private Context mContext;

    public CategoryAdapter(FragmentActivity activity, JSONData data) {
        this.jsonData=data;
        this.mContext=activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("tag", "onCreateViewHolder: ");
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_recyclerview_item, parent, false);
        return new SingleItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingleItemHolder singleItemHolder= (SingleItemHolder) holder;
        singleItemHolder.imgTitle.setText(jsonData.getResponse().getItems().getLists().get(position).getTitle());
        Glide.with(mContext).load(jsonData.getResponse().getItems().getLists().get(position).getImg().getSmall()).into(singleItemHolder.itemImage);

    }

    @Override
    public int getItemCount() {
        return jsonData.getResponse().getItems().getLists().size();
    }

    public class SingleItemHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView imgTitle;

        public SingleItemHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            imgTitle = itemView.findViewById(R.id.img_title);
        }
    }
}
