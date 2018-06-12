package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.support.annotation.Nullable;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.interfaces.IFeedInteractor;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BasePaginationPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IFeedFragment;
import vironit.pavelnovak.myappvironit.utils.AppLog;

@InjectViewState
public class FeedPresenter extends BasePaginationPresenter<IFeedFragment> {

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

    @Override
    protected void loadData(int totalItemCount, @Nullable String lastItemId) {
        super.loadData(totalItemCount, lastItemId);
        addPaginationDisposable(mIFeedInteractor.getFeeds(totalItemCount / getItemsCountPerPage(), getItemsCountPerPage())
                .observeOn(mUIScheduler)
                .doOnSuccess(dataElement -> setNextPageAllow(dataElement.getArticles()))
                .doOnSuccess(dataElement -> getViewState().addData(dataElement.getArticles()))
                .doFinally(() -> getViewState().hidePaginationProgress())
                .subscribe(list -> AppLog.logPresenter(this, "SUCCESS!"), this));
    }

    @Override
    protected int getItemsCountPerPage() {
        return 8;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        refreshData();
    }

    //    public List<IItemFeed> parseArticles(List<Article> articleList) {
//        List<IItemFeed> resultList = new ArrayList<>();
//        for (Article article : articleList) {
//            resultList.add(new FeedPost(
//                    article.getTitle(),
//                    article.getDescription(),
//                    article.getUrlToImage()
//            ));
//        }
//        return resultList;
//    }

}

