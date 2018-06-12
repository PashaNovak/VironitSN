package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.base.base_adapters.BasePaginationRecyclerViewAdapter;
import vironit.pavelnovak.myappvironit.adapters.feeds.FeedAdapter;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Article;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.FeedPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BasePaginationFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IFeedFragment;

public class FeedFragment extends BasePaginationFragment<FeedPresenter> implements IFeedFragment {

    @InjectPresenter
    FeedPresenter mFeedPresenter;

    private FeedAdapter mFeedAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_feed_fragment;
    }

    @Override
    protected FeedPresenter getPresenter() {
        return mFeedPresenter;
    }

    public static FeedFragment getInstance(){
        return new FeedFragment();
    }

    @Override
    protected void initViewBeforePresenterAttach() {
        super.initViewBeforePresenterAttach();
    }

    @Nullable
    @Override
    protected BasePaginationRecyclerViewAdapter getBasePaginationRecyclerViewAdapter() {
        return null;
    }

    @Override
    protected void setPaginationRecyclerAdapter() {
        mFeedAdapter = new FeedAdapter();
        recyclerView.setAdapter(mFeedAdapter);
    }

    @Override
    public void addData(List<Article> data) {
        mFeedAdapter.addData(data);
    }

    @Override
    protected void setLayoutManager() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}
