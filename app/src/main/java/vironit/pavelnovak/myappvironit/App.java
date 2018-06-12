package vironit.pavelnovak.myappvironit;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;

import com.facebook.stetho.Stetho;
import com.twitter.sdk.android.core.Twitter;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.HasServiceInjector;
import vironit.pavelnovak.myappvironit.di.components.AppComponent;
import vironit.pavelnovak.myappvironit.di.components.DaggerAppComponent;

public class App extends Application implements HasActivityInjector, HasBroadcastReceiverInjector, HasServiceInjector {

    private static AppComponent component;

    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverDispatchingAndroidInjector;

    public static AppComponent getAppComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger2();
    }

    private void initDagger2() {
        component = DaggerAppComponent.builder()
                .appContext(this)
                .build();

        component.inject(this);

        Twitter.initialize(this);
        Stetho.initializeWithDefaults(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
        return broadcastReceiverDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceDispatchingAndroidInjector;
    }

}
