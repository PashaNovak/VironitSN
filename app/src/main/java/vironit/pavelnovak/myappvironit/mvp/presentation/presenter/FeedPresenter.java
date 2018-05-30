package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.interfaces.IFeedInteractor;
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
        loadNews();
    }

    private void loadNews() {
        getViewState().showProgress();
        addLiteDisposable(mIFeedInteractor.getFeeds()
                .observeOn(mUIScheduler)
                .doOnSuccess(list -> {
                })
                .doFinally(() -> getViewState().hideProgress())
                .subscribe(list -> AppLog.logPresenter(this,"OOOOOKKKKK"),
                        throwable -> AppLog.logPresenter(this,throwable)));
    }
}

