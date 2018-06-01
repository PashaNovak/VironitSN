package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.IMainView;

@InjectViewState
public class MainPresenter extends BaseAppPresenter<IMainView> {

    public void showProgress() {
        getViewState().showProgress();
    }

    public void showProgressWithMessage(String text) {
        getViewState().showProgress(text);
    }

    public void showMessage(String text) {
        getViewState().showMessage(text, true, null, null);
    }

    public void showDialogMessage(String text) {
        getViewState().showDialogMessage(text, true);
    }

    @NonNull
    @Override
    public String getString(int strResId) {
        return null;
    }

    public MainPresenter(){
        App.getAppComponent().inject(this);
    }

    @NonNull
    @Override
    public String getString(int resId, @NonNull Object... formatArgs) {
        return null;
    }

    public void showDialogWithOptions(String title, String message) {
        getViewState().showDialogWithOptions(title, message,
                "ok", "cancel",
                null, null, true);
    }

}
