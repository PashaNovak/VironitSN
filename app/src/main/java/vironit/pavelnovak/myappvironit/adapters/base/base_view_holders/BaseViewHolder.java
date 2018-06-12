package vironit.pavelnovak.myappvironit.adapters.base.base_view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;

public abstract class BaseViewHolder<ListItem> extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bindView(ListItem item);
}
