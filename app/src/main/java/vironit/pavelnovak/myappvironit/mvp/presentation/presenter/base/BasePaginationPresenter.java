package vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base;

import android.support.annotation.Nullable;

import java.util.List;

import io.reactivex.disposables.Disposable;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBasePaginationView;
import vironit.pavelnovak.myappvironit.utils.AppLog;

public abstract class BasePaginationPresenter<V extends IBasePaginationView> extends BaseAppPresenter<V>{

    protected boolean mIsNextPageAllow = true;

    @Nullable
    private Disposable mPaginationDisposable = null;

    @Override
    protected void defaultErrorHandling(Throwable throwable) {
        AppLog.logPresenter(this);
        getViewState().hidePaginationProgress();
        super.defaultErrorHandling(throwable);
    }

    @Override
    protected void clearLiteDisposable() {
        AppLog.logPresenter(this);
        clearPaginationDisposable();
        super.clearLiteDisposable();
    }

    public void loadDataCheck(int totalItemCount,
                              int lastVisibleItemPosition,
                              @Nullable String lastItemId) {
        AppLog.logPresenter(this);
        if (lastVisibleItemPosition + getItemsCountPerPage() / 3 > totalItemCount
                && mIsNextPageAllow
                && !isLoading()) {
            loadData(totalItemCount, lastItemId);
        }
    }

    protected void addPaginationDisposable(@Nullable Disposable disposable) {
        AppLog.logPresenter(this);
        if (disposable != null) {
            clearPaginationDisposable();
            mPaginationDisposable = disposable;
        }
    }

    protected void clearPaginationDisposable() {
        AppLog.logPresenter(this);
        if (isLoading()) {
            mPaginationDisposable.dispose();
        }
    }

    private boolean isLoading() {
        AppLog.logPresenter(this);
        return mPaginationDisposable != null && !mPaginationDisposable.isDisposed();
    }

    public void refreshData() {
        AppLog.logPresenter(this);
        mIsNextPageAllow = true;
        clearPaginationDisposable();
        getViewState().removeData();
        loadData(0, null);
    }

    protected void loadData(int totalItemCount, @Nullable String lastItemId) {
        AppLog.logPresenter(this);
        getViewState().showPaginationProgress();
    }

    protected int getItemsCountPerPage() {
        return IAppConstants.DEFAULT_ITEMS_COUNT_PER_PAGE;
    }

    protected void setNextPageAllow(@Nullable List list) {
        mIsNextPageAllow = !(list == null || (list.size() < getItemsCountPerPage()));
    }
}
