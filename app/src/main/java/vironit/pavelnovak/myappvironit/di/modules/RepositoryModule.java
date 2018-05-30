package vironit.pavelnovak.myappvironit.di.modules;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import vironit.pavelnovak.myappvironit.mvp.model.repository.implementation.FeedRepositoryImpl;
import vironit.pavelnovak.myappvironit.mvp.model.repository.interfaces.IFeedRepository;

@Module
public interface RepositoryModule {

    @Binds
    @Singleton
    IFeedRepository providesFeedRepository(FeedRepositoryImpl feedRepositoryImpl);
}
