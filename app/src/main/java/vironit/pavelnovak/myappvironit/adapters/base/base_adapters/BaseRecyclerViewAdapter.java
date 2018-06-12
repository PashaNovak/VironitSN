package vironit.pavelnovak.myappvironit.adapters.base.base_adapters;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vironit.pavelnovak.myappvironit.utils.AppLog;

public abstract class BaseRecyclerViewAdapter<Data, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private final List<Data> mDataList = new ArrayList<>();

    protected BaseRecyclerViewAdapter(){

    }

    public void addData(List<Data> dataItems){
        AppLog.logObject(BaseRecyclerViewAdapter.class, "");
        int size = mDataList.size();
        this.mDataList.addAll(dataItems);
        notifyItemRangeInserted(size, dataItems.size());
    }

    public void removeData(){
        AppLog.logObject(BaseRecyclerViewAdapter.class, "");
        int size = mDataList.size();
        mDataList.clear();
        notifyItemRangeRemoved(0, size);
    }


    @Override
    public int getItemCount() {
        AppLog.logObject(BaseRecyclerViewAdapter.class, "");
        return mDataList.size();
    }

    public int getRealItemsCount(){
        AppLog.logObject(BaseRecyclerViewAdapter.class, "");
        return getItemCount();
    }

    protected List<Data> getDataList(){
        AppLog.logObject(BaseRecyclerViewAdapter.class, "");
        return mDataList;
    }
}
