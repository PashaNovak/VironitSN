package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.presenter.InjectPresenter;

import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.LoginPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter>  {

    @InjectPresenter
    LoginPresenter mLoginPresenter;

    public static void start(@Nullable Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, LoginActivity.class));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected LoginPresenter getPresenter() {
        return mLoginPresenter;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.layout_login_activity;
    }

    @Override
    public int getRootViewResId() {
        return R.id.v_root_login_activity;
    }


}
