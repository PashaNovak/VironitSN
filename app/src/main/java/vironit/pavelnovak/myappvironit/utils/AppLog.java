package vironit.pavelnovak.myappvironit.utils;

import android.app.Activity;
import android.support.annotation.NonNull;

import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BasePresenter;
import vironit.poddubnaya.myappvironit.BuildConfig;

public abstract class AppLog {


    public static void logPresenter(@NonNull BasePresenter presenter){

    }

    public static void logActivity(@NonNull Activity activity){

    }

    private static boolean isLogEnabled(){
        return BuildConfig.DEBUG;
    }


}
