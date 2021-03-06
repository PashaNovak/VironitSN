package vironit.pavelnovak.myappvironit.di.modules;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.implementation.FeedInteractorImpl;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.implementation.OAuthInteractorImpl;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.interfaces.IFeedInteractor;
import vironit.pavelnovak.myappvironit.mvp.model.interactor.interfaces.IOAuthInteractor;

@Module
public interface InteractorModule {

    @Binds
    @Singleton
    IFeedInteractor provideFeedInteractor(FeedInteractorImpl feedInteractor);

    /*@Binds
    @Singleton
    IOAuthInteractor provideOAuthInteractor(OAuthInteractorImpl oAuthInteractor);*/
}
