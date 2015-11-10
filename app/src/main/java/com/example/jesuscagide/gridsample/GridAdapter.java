package com.example.jesuscagide.gridsample;

/**
 * Created by jesuscagide on 11/10/15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    List<FeedItem> mItems;
    Context mContext;

    public GridAdapter(Context context, List<FeedItem> feedItemList) {
        this.mItems = feedItemList;
        this.mContext =  context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        FeedItem item = mItems.get(i);
        viewHolder.title.setText(item.getTitle());

        Picasso.with(mContext).load(item.getThumbnail())
                .error(android.R.drawable.ic_btn_speak_now)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(viewHolder.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        return (null != mItems ? mItems.size() : 0);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            title = (TextView)itemView.findViewById(R.id.feed_title);
        }
    }
}
