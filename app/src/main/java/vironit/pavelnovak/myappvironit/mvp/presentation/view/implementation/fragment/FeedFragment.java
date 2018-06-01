package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.adapters.feeds.FeedAdapter;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Data;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.FeedPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IFeedFragment;

public class FeedFragment extends BaseFragment<FeedPresenter> implements IFeedFragment {

    @InjectPresenter
    FeedPresenter mFeedPresenter;

    @BindView(R.id.feed_recycler_view)
    RecyclerView mFeedRecyclerView;

    @BindView(R.id.loading_spinner_feed)
    ProgressBar loadingSpinner;

    private static final int PAGE_SIZE = 10;

    private int mPage = 0;

    private FeedAdapter adapter;

    private LinearLayoutManager llm;

    public static FeedFragment getInstance(){
        return new FeedFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_feed_fragment;
    }

    @Override
    protected FeedPresenter getPresenter() {
        return mFeedPresenter;
    }

    @Override
    public void onGetDataFailure() {

    }


    @Override
    protected void initBeforePresenterAttach() {
        super.initBeforePresenterAttach();
        setLoadingSpinnerState(View.VISIBLE);
        llm = new LinearLayoutManager(this.getContext());
        mFeedRecyclerView.setLayoutManager(llm);
        mFeedRecyclerView.addOnScrollListener(getOnRecyclerScrollListener());
        mFeedPresenter.loadNews(++mPage, PAGE_SIZE);
    }

    private RecyclerView.OnScrollListener getOnRecyclerScrollListener() {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = llm.getChildCount();
                int totalItemCount = llm.getItemCount();
                int firstVisibleItemPosition = llm.findFirstVisibleItemPosition();
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    mFeedPresenter.loadNews(++mPage, PAGE_SIZE);
                }
            }
        };
    }

    @Override
    public void onGetDataSuccess(Data newsFeedData) {
        if (mPage > 1) {
            adapter.addNews(mFeedPresenter.parseArticles(newsFeedData.getArticles()));
            adapter.notifyDataSetChanged();
        } else {
            adapter =
                    new FeedAdapter(mFeedPresenter.parseArticles(newsFeedData.getArticles()));
            mFeedRecyclerView.setAdapter(adapter);
            setLoadingSpinnerState(View.GONE);
        }

    }

    @Override
    public void setLoadingSpinnerState(int visibility) {
        loadingSpinner.setVisibility(visibility);
    }
}
