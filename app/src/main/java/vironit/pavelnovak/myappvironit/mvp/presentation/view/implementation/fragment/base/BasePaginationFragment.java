package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.base.base_adapters.BasePaginationRecyclerViewAdapter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BasePaginationPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBasePaginationView;
import vironit.pavelnovak.myappvironit.utils.RecyclerViewUtil;

public abstract class BasePaginationFragment<T extends BasePaginationPresenter> extends BaseFragment<T> implements IBasePaginationView {

    private RecyclerView.LayoutManager layoutManager;

    @BindView(R.id.srl_pagination_progress)
    protected SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.rv_pagination_items)
    protected RecyclerView recyclerView;

    private Runnable mEnableRefreshRunnable = () -> {
        if (!swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
        }
    };

    private Runnable mDisableRefreshRunnable = () -> {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    };

    @Override
    protected void initViewBeforePresenterAttach() {
        super.initViewBeforePresenterAttach();
        setLayoutManager();
        setPaginationRecyclerAdapter();
        setScrollListener();
        setRefreshListener();
    }

    protected void setScrollListener() {
        RecyclerViewUtil.setOnScrollListener(recyclerView, getPresenter());
    }

    @Nullable
    protected abstract BasePaginationRecyclerViewAdapter getBasePaginationRecyclerViewAdapter();

    protected abstract void setPaginationRecyclerAdapter();

    protected abstract void setLayoutManager();

    protected void setRefreshListener() {
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(() -> getPresenter().refreshData());
    }

    @Override
    public void showPaginationProgress() {
        swipeRefreshLayout.removeCallbacks(mDisableRefreshRunnable);
        swipeRefreshLayout.post(mEnableRefreshRunnable);
    }

    @Override
    public void hidePaginationProgress() {
        swipeRefreshLayout.removeCallbacks(mEnableRefreshRunnable);
        swipeRefreshLayout.post(mDisableRefreshRunnable);
    }

    @Override
    public void removeData() {
        BasePaginationRecyclerViewAdapter basePaginationRecyclerViewAdapter = getBasePaginationRecyclerViewAdapter();
        if (basePaginationRecyclerViewAdapter != null) {
            basePaginationRecyclerViewAdapter.removeData();
        }
    }

    @Override
    public void onDestroyView() {
        hidePaginationProgress();
        super.onDestroyView();
    }
}
