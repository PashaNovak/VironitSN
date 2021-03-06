package vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;
import vironit.pavelnovak.myappvironit.mvp.model.manager.interfaces.IResourcesManager;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;
import vironit.pavelnovak.myappvironit.utils.AppLog;

public abstract class BasePresenter<View extends IBaseView> extends MvpPresenter<View> {

    private final CompositeDisposable mLiteCompositeDisposable = new CompositeDisposable();
    private final CompositeDisposable mHardCompositeDisposable = new CompositeDisposable();

    @Inject
    @Named(IAppConstants.COMPUTATION_SCHEDULER)
    protected Scheduler mComputationScheduler;

    @Inject
    @Named(IAppConstants.IO_SCHEDULER)
    protected Scheduler mIOScheduler;

    @Inject
    @Named(IAppConstants.UI_SCHEDULER)
    protected Scheduler mUIScheduler;

    @Inject
    IResourcesManager mIResourcesManager;

    @Override
    public void attachView(View view) {
        AppLog.logPresenter(this);
        super.attachView(view);
    }

    @Override
    protected void onFirstViewAttach() {
        AppLog.logPresenter(this);
        super.onFirstViewAttach();
    }

    @Override
    public void detachView(View view) {
        mLiteCompositeDisposable.clear();
        AppLog.logPresenter(this);
        super.detachView(view);
    }

    @Override
    public void destroyView(View view) {

        AppLog.logPresenter(this);
        super.destroyView(view);
    }

    @Override
    public void onDestroy() {
        mHardCompositeDisposable.clear();
        AppLog.logPresenter(this);
        super.onDestroy();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data, @NonNull BaseActivity activity) {
        AppLog.logPresenter(this);

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults, @NonNull BaseActivity activity) {
        AppLog.logPresenter(this);

    }

    protected void addLiteDisposable(@Nullable Disposable disposable) {
        if (disposable != null) {
            mLiteCompositeDisposable.add(disposable);
        }
    }

    protected void addHardDisposable(@Nullable Disposable disposable) {
        if (disposable != null) {
            mHardCompositeDisposable.add(disposable);
        }
    }

    protected void clearLiteDisposable(){
        mLiteCompositeDisposable.clear();
    }

    protected void clearHardDisposable(){
        mHardCompositeDisposable.clear();
    }

    protected String getString(@StringRes int resId){
        return mIResourcesManager.getString(resId);
    }

    protected final void clearDisposableIfPossible(@Nullable Disposable disposable){
        if (disposable != null && !disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
