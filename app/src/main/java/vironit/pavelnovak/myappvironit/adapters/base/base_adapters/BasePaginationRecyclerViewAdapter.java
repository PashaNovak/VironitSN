package vironit.pavelnovak.myappvironit.adapters.base.base_adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

public abstract class BasePaginationRecyclerViewAdapter<Data, VH extends RecyclerView.ViewHolder> extends BaseRecyclerViewAdapter<Data, VH> {

    public @Nullable String getLastItem(){
        return null;
    }
}
