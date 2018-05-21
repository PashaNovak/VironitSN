package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

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

    public void showDialogWithOptions(String title, String message) {
        getViewState().showDialogWithOptions(title, message,
                "ok", "cancel",
                null, null, true);
    }

}
