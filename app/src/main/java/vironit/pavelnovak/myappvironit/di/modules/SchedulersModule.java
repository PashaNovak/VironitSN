package vironit.pavelnovak.myappvironit.di.modules;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;

@Module
public class SchedulersModule {

    @Provides
    @Singleton
    @Named(IAppConstants.COMPUTATION_SCHEDULER)
    Scheduler provideComputationScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named(IAppConstants.UI_SCHEDULER)
    Scheduler provideUIScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(IAppConstants.IO_SCHEDULER)
    Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

}
