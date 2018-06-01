package vironit.pavelnovak.myappvironit.adapters.feeds;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.feeds.view_holders.FeedPostViewHolder;
import vironit.pavelnovak.myappvironit.adapters.feeds.view_holders.base.BaseFeedViewHolder;

public class FeedAdapter extends RecyclerView.Adapter<BaseFeedViewHolder> {

    private final List<IItemFeed> items;

    public FeedAdapter(List<IItemFeed> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BaseFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TypeFeedEnum.POST.ordinal()){
            View postView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_feed_post, parent, false);
            return new FeedPostViewHolder(postView);
        } else if (viewType == TypeFeedEnum.AD.ordinal()){
            View adView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_feed_ad, parent, false);
            return new FeedPostViewHolder(adView);
        } else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseFeedViewHolder holder, int position) {
        holder.bindView(this.items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addNews(List<IItemFeed> feedItems) {
        this.items.addAll(feedItems);
    }

    @Override
    public int getItemViewType(int position) {
        return this.items.get(position).getItemFeedType().ordinal();
    }
}
