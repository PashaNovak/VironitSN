package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.GoogleMapsActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.fragment.IChatFragment;

@InjectViewState
public class ChatPresenter extends BaseAppPresenter<IChatFragment> {
    @NonNull
    @Override
    public String getString(int strResId) {
        return null;
    }

    public void GoToGoogleMap(Context context){
        GoogleMapsActivity.start(context);
    }
}
