package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.ILoginView;

@InjectViewState
public class LoginPresenter extends BaseAppPresenter<ILoginView> {

    private TwitterAuthClient mTwitterAuthClient = new TwitterAuthClient();
    private CallbackManager mCallbackManager;
    private String selectedLoginButton = "";

    public LoginPresenter() {
        App.getAppComponent().inject(this);
    }

    public void facebookBtnClicked(){
        selectedLoginButton = IAppConstants.FACEBOOK;
        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
    }

    public void twitterBtnButton(@NonNull Activity activity){
        selectedLoginButton = IAppConstants.TWITTER;
        mTwitterAuthClient.authorize(activity, new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

            }

            @Override
            public void failure(TwitterException exception) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data, @NonNull BaseActivity activity) {
        super.onActivityResult(requestCode, resultCode, data, activity);
        mTwitterAuthClient.onActivityResult(requestCode, resultCode, data);
    }
}
