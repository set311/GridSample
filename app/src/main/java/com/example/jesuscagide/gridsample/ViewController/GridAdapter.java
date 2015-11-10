package com.example.jesuscagide.gridsample.ViewController;

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

import com.example.jesuscagide.gridsample.Model.FeedItem;
import com.example.jesuscagide.gridsample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder>  implements View.OnClickListener {
    List<FeedItem> mItems;
    Context mContext;
    IMainActivity delegate;


    public GridAdapter(Context context, List<FeedItem> feedItemList) {
        this.mItems = feedItemList;
        this.mContext =  context;
        this.delegate = (IMainActivity)context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        v.setOnClickListener(this);
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

        viewHolder.itemView.setTag(viewHolder);

    }

    @Override
    public int getItemCount() {
        return (null != mItems ? mItems.size() : 0);
    }

    @Override
    public void onClick(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        int position = holder.getAdapterPosition();

        FeedItem feedItem = mItems.get(position);
        delegate.cmdCellSelected(feedItem);
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
