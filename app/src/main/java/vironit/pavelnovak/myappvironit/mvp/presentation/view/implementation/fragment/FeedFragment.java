package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment;

import com.arellomobile.mvp.presenter.InjectPresenter;

import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.FeedPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IFeedFragment;

public class FeedFragment extends BaseFragment<FeedPresenter> implements IFeedFragment {

    @InjectPresenter
    FeedPresenter mFeedPresenter;

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
}
