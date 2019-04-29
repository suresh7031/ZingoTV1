package com.example.zingotv.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zingotv.Models.JSONData;
import com.example.zingotv.R;
import com.example.zingotv.Utils.EventCounter;

import java.util.List;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private JSONData jsonData;
    private Context mContext;
    int seleted_position = 0;
    EventCounter eventCounter;


    public Adapter(FragmentActivity activity, JSONData data) {
        /*Log.i("tag", "Adapter: "+data.size());*/

        this.mContext = activity;
        this.jsonData = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        Log.i("tag", "onCreateViewHolder: ");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_recyclerview_item, parent, false);
        return new SingleItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final SingleItemHolder singleItemHolder = (SingleItemHolder) holder;
        singleItemHolder.imgTitle.setText(jsonData.getResponse().getItems().getLists().get(position).getTitle());
        Glide.with(mContext).load(jsonData.getResponse().getItems().getLists().get(position).getImg().getSmall()).into(singleItemHolder.itemImage);
        //  singleItemHolder.Event.setText(jsonData.getResponse().getItems().getLists().get(position).getEvents().get(0).getName());

        eventCounter=new EventCounter(0);
        Log.i("aj", "onBindViewHolder: "+position);
        singleItemHolder.chright.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int i=eventCounter.getCurrentPosition();
                Log.i("aj", "onClick: " + i);
                if (i < jsonData.getResponse().getItems().getLists().get(position).getEvents().size()) {
                    Log.i("aj", "onClick: size");
                    singleItemHolder.Event.setText(jsonData.getResponse().getItems().getLists().get(position).getEvents().get(i).getName());
                    i++;
                    eventCounter.setCurrentPosition(i);
                }

                //seleted_position = position;
                //notifyDataSetChanged();
            }
        });

      /*  if (seleted_position == position) {
            singleItemHolder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));

        } else {
            singleItemHolder.linearLayout.setBackgroundColor(Color.TRANSPARENT);
        }*/


    }

    @Override
    public int getItemCount() {
        /*Log.i("tag", "getItemCount: "+jsonData.size());*/
        return jsonData.getResponse().getItems().getLists().size();
    }

    public class SingleItemHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView imgTitle, Event;
        LinearLayout linearLayout;
        ImageView chleft;
        ImageView chright;

        public SingleItemHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            imgTitle = itemView.findViewById(R.id.img_title);
            linearLayout = itemView.findViewById(R.id.events);
            Event = itemView.findViewById(R.id.event);
            chleft = itemImage.findViewById(R.id.chleft);
            chright = itemView.findViewById(R.id.chright);
        }
    }
}