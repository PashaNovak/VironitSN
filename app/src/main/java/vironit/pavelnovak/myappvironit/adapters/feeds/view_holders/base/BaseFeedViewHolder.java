package vironit.pavelnovak.myappvironit.adapters.feeds.view_holders.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;

public abstract class BaseFeedViewHolder extends RecyclerView.ViewHolder{

    public BaseFeedViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindView(IItemFeed typeFeedInterface);
}
