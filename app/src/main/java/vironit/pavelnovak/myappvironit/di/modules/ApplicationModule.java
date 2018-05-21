package vironit.pavelnovak.myappvironit.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vironit.pavelnovak.myappvironit.App;

@Module
public class ApplicationModule {
    @Provides
    @Singleton
    Context provideContext(App app){
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(App app){
        return PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
    }
}
