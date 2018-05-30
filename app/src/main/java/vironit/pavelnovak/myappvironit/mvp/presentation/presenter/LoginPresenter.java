package vironit.pavelnovak.myappvironit.mvp.presentation.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

import java.util.Collections;

import javax.inject.Inject;

import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BaseAppPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.base.BaseActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.interfaces.ILoginView;
import vironit.pavelnovak.myappvironit.utils.AppLog;

@InjectViewState
public class LoginPresenter extends BaseAppPresenter<ILoginView> {

    @Inject
    TwitterAuthClient mTwitterAuthClient;

    @Inject
    CallbackManager mCallbackManager;

    @Inject
    GoogleSignInClient mGoogleSignInClient;

    private String selectedLoginButton = "";

    public LoginPresenter() {
        App.getAppComponent().inject(this);
    }

    public void facebookBtnClicked(@NonNull Activity activity) {
        selectedLoginButton = IAppConstants.FACEBOOK;
        LoginManager.getInstance().logInWithPublishPermissions(activity,
                Collections.singletonList("public_profile"));
        mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        AppLog.logPresenter(LoginPresenter.this);
                        getViewState().showSuccessMessage();
                    }

                    @Override
                    public void onCancel() {
                        AppLog.logPresenter(LoginPresenter.this);
                        getViewState().showFailMessage();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        AppLog.logPresenter(LoginPresenter.this);
                        getViewState().showFailMessage();
                    }
                });
    }

    public void twitterBtnClicked(@NonNull Activity activity) {
        selectedLoginButton = IAppConstants.TWITTER;
        mTwitterAuthClient.authorize(activity, new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                AppLog.logPresenter(LoginPresenter.this);
                getViewState().showSuccessMessage();
            }

            @Override
            public void failure(TwitterException exception) {
                AppLog.logPresenter(LoginPresenter.this);
                getViewState().showFailMessage();
            }
        });
    }

    public void googleBtnClicked(@NonNull Activity activity) {
        selectedLoginButton = IAppConstants.GOOGLE;
        activity.startActivityForResult(mGoogleSignInClient.getSignInIntent(), IAppConstants.RC_SIGN_IN);
    }

    private void handleSignInResultGoogle(Task<GoogleSignInAccount> competedTask) {
        try {
            AppLog.logPresenter(LoginPresenter.this);
            GoogleSignInAccount googleSignInAccount = competedTask.getResult(ApiException.class);
            getViewState().showSuccessMessage();
        } catch (ApiException e) {
            AppLog.logPresenter(LoginPresenter.this);
            getViewState().showFailMessage();
        }
    }

    public void signOutFromAllAccounts() {
        TwitterSession twitterSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
        if (twitterSession != null) {
            TwitterCore.getInstance().getSessionManager().clearActiveSession();
        }
        LoginManager.getInstance().logOut();
        mGoogleSignInClient.signOut();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data, @NonNull BaseActivity activity) {
        super.onActivityResult(requestCode, resultCode, data, activity);
        mTwitterAuthClient.onActivityResult(requestCode, resultCode, data);
        switch (selectedLoginButton) {
            case IAppConstants.FACEBOOK:
                mCallbackManager.onActivityResult(requestCode, resultCode, data);
                break;
            case IAppConstants.GOOGLE:
                if (requestCode == IAppConstants.RC_SIGN_IN) {
                    Task<GoogleSignInAccount> googleSignInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
                    handleSignInResultGoogle(googleSignInAccountTask);
                }
                break;
            case IAppConstants.TWITTER:
                mTwitterAuthClient.onActivityResult(requestCode, resultCode, data);
                break;
            default:
                break;
        }
    }
}
