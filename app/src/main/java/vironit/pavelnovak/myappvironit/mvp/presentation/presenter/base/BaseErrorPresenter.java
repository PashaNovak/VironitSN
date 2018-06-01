package vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base;

import android.content.res.Resources;

import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;
import vironit.pavelnovak.myappvironit.utils.exceptions.VironitSocialNetworkException;

public abstract class BaseErrorPresenter<View extends IBaseView> extends BasePresenter<View> implements Consumer<Throwable>{

    @Override
    public void accept(@Nullable Throwable throwable) throws Exception {
        if (throwable != null && throwable instanceof Exception){
            VironitSocialNetworkException exception = (VironitSocialNetworkException) throwable;
            if (exception.getStatus() != null){
                switch (exception.getStatus()){

                }
            } if (exception.getResId() != null){
                getViewState().showAutocloseableMessage(getString(exception.getResId()));
            }
        }
    }

    protected void handleUnkbownError(@Nullable Throwable throwable){
        getViewState().showAutocloseableMessage(throwable.getMessage());
    }
}
