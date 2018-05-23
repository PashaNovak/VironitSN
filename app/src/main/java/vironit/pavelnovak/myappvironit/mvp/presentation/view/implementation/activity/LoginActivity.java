package vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import vironit.pavelnovak.myappvironit.R;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.LoginPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.ILoginView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {

    @InjectPresenter
    LoginPresenter mLoginPresenter;

    @BindView(R.id.btn_facebook)
    CircleImageView btn_facebook;

    @BindView(R.id.btn_google)
    CircleImageView btn_google;

    @BindView(R.id.btn_twitter)
    CircleImageView btn_twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mLoginPresenter.signOutFromAllAccounts();
        btn_facebook.setOnClickListener(v -> mLoginPresenter.facebookBtnClicked(this));
        btn_google.setOnClickListener(v -> mLoginPresenter.googleBtnClicked(this));
        btn_twitter.setOnClickListener(v -> mLoginPresenter.twitterBtnClicked(this));
    }

    public static void start(@Nullable Context context) {
        if (context != null) {
            context.startActivity(new Intent(context, LoginActivity.class));
        }
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


    @Override
    public void showSuccessMessage() {
        showDialogMessage(getString(R.string.success_login),true);
    }

    @Override
    public void showFailMessage() {
        showDialogMessage(getString(R.string.error_login),true);
    }
}
