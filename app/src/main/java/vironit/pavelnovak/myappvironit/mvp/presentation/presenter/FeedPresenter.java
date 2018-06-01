package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.adapters.feeds.IItemFeed;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.interfaces.IFeedInteractor;
import vironit.pavelnovak.myappvironit.mvp.model.repository.dto.Article;
import vironit.pavelnovak.myappvironit.mvp.model.repository.feed.FeedPost;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IFeedFragment;
import vironit.pavelnovak.myappvironit.utils.AppLog;

@InjectViewState
public class FeedPresenter extends BaseAppPresenter<IFeedFragment> {

    @Inject
    IFeedInteractor mIFeedInteractor;

    public FeedPresenter() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void attachView(IFeedFragment view) {
        super.attachView(view);
        //loadNews();
    }

    public void loadNews(int page, int pageSize) {
        getViewState().showProgress();
        addLiteDisposable(mIFeedInteractor.getFeeds()
                .observeOn(mUIScheduler)
                .doOnSuccess(list -> getViewState().onGetDataSuccess(list))
                .doFinally(() -> getViewState().hideProgress())
                .subscribe(list -> AppLog.logPresenter(this,"OOOOOKKKKK"),
                        throwable -> AppLog.logPresenter(this,throwable)));
    }

    public List<IItemFeed> parseArticles(List<Article> articleList) {
        List<IItemFeed> resultList = new ArrayList<>();
        for (Article article : articleList) {
            resultList.add(new FeedPost(
                    article.getTitle(),
                    article.getDescription(),
                    article.getUrlToImage()
            ));
        }
        return resultList;
    }

    @NonNull
    @Override
    public String getString(int strResId) {
        return null;
    }

    @NonNull
    @Override
    public String getString(int resId, @NonNull Object... formatArgs) {
        return null;
    }
}

