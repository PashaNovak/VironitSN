package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IChatFragment;

@InjectViewState
public class ChatPresenter extends BaseAppPresenter<IChatFragment> {
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
