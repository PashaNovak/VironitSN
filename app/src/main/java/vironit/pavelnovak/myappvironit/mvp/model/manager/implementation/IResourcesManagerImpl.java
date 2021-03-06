package vironit.pavelnovak.myappvironit.mvp.model.manager.implementation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import javax.inject.Inject;

import vironit.pavelnovak.myappvironit.mvp.model.manager.interfaces.IResourcesManager;

public class IResourcesManagerImpl implements IResourcesManager {

    @NonNull
    private final Context mAppContext;

    @Inject
    public IResourcesManagerImpl(@NonNull Context AppContext) {
        mAppContext = AppContext;
    }

    @NonNull
    @Override
    public String getString(@StringRes int strResId) {
        String str = null;
        try {
            str = mAppContext.getString(strResId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str != null ? str : "";
    }

    @NonNull
    @Override
    public String getString(@StringRes int resId,@NonNull Object... formatArgs) {
        String str = null;
        try {
            str = mAppContext.getString(resId, formatArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str != null ? str : "";
    }
}
