package vironit.pavelnovak.myappvironit.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.base.BasePresenter;
import vironit.pavelnovak.myappvironit.BuildConfig;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.base.BaseFragment;

public abstract class AppLog {

    private static String APP_TAG = "VIRONIT_APP_TAG";

    public static void logPresenter(@NonNull BasePresenter presenter){
        if (isLogEnabled()){
            Log.i(getTag(APP_TAG), getInfo(presenter));
        } else Log.i(getTag(APP_TAG), "isLogEnabled false");
    }

    public static void logFragment(@NonNull BaseFragment fragment){
        if (isLogEnabled()){
            Log.i(getTag(APP_TAG), getInfo(fragment));
        } else Log.i(getTag(APP_TAG), "isLogEnabled false");
    }

    public static void logActivity(@NonNull Activity activity){
        if (isLogEnabled()){
            Log.i(getTag(APP_TAG), getInfo(activity));
        } else Log.i(getTag(APP_TAG), "isLogEnabled false");
    }

    private static boolean isLogEnabled(){
        return BuildConfig.DEBUG;
    }

    private static String getMethodName() {
        try {
            return Thread.currentThread().getStackTrace()[4].getMethodName();
        } catch (Exception e){
            return "Unknown method";
        }
    }

    private static String getClassName(Object object){
        try{
            return object.getClass().getSimpleName();
        } catch (Exception e){
            return "Unknown class";
        }
    }

    private static String getInfo(Object object){
        return getClassName(object) + "." + getMethodName() + "()";
    }

    private static String getTag(String tag){
        return tag;
    }
}
