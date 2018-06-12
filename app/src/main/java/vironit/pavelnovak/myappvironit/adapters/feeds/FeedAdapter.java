package vironit.pavelnovak.myappvironit.adapters.feeds;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.base.base_adapters.BasePaginationRecyclerViewAdapter;
import vironit.pavelnovak.myappvironit.adapters.base.base_view_holders.BaseViewHolder;
import vironit.pavelnovak.myappvironit.adapters.feeds.view_holders.FeedPostViewHolder;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Article;

public class FeedAdapter extends BasePaginationRecyclerViewAdapter<Article, BaseViewHolder> {

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post, parent, false);
        return new FeedPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindView(getDataList().get(position));
    }
}
