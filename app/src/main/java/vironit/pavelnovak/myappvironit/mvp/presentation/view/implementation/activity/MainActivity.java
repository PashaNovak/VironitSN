package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;

import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.MainPresenter;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.IMainView;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    @InjectPresenter
    MainPresenter mMainPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.layout_main_activity;
    }

    @Override
    public int getRootViewResId() {
        return R.id.main_activity_root_view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter.showProgressWithMessage(getString(R.string.big_text));
    }
}
