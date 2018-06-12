package vironit.pavelnovak.myappvironit.utils;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import vironit.pavelnovak.myappvironit.adapters.base.base_adapters.BasePaginationRecyclerViewAdapter;
import vironit.pavelnovak.myappvironit.adapters.base.base_adapters.BaseRecyclerViewAdapter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BasePaginationPresenter;

public abstract class RecyclerViewUtil {

    public static void setOnScrollListener(@Nullable RecyclerView recyclerView,
                                           @Nullable BasePaginationPresenter basePaginationPresenter) {
        if (recyclerView != null && basePaginationPresenter != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy > 0) {
                        RecyclerView.Adapter adapter = recyclerView.getAdapter();
                        if (adapter instanceof BaseRecyclerViewAdapter) {
                            BaseRecyclerViewAdapter baseRecyclerViewAdapter = (BaseRecyclerViewAdapter) adapter;
                            int realItemCount = baseRecyclerViewAdapter.getRealItemsCount();
                            int lastVisibleItemPosition = getLastVisibleItemPosition(recyclerView);
                            @Nullable String lastItemId = null;
                            if (baseRecyclerViewAdapter instanceof BasePaginationRecyclerViewAdapter) {
                                lastItemId = ((BasePaginationRecyclerViewAdapter) baseRecyclerViewAdapter).getLastItem();
                            }
                            basePaginationPresenter.loadDataCheck(realItemCount, lastVisibleItemPosition, lastItemId);
                        }
                    }
                }
            });
        }
    }

    private static int getLastVisibleItemPosition(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        return linearLayoutManager.findLastVisibleItemPosition();
    }
}
