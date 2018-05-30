package vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces;

import android.support.v4.app.Fragment;

import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.base.IBaseView;

public interface IMainView extends IBaseView {
    void showSelectedFragment(Fragment fragment);
}
