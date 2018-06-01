package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.ITestView;

@InjectViewState
public class TestPresenter extends BaseAppPresenter<ITestView> {

    @Override
    public void attachView(ITestView view) {
        super.attachView(view);
        getViewState().showProgress();
        Single.just(1)
                .delay(5000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(as-> {
                    getViewState().hideProgress();
                }, throwable -> throwable.printStackTrace());
    }

    public void asdas(){
        getViewState().hideProgress();
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
