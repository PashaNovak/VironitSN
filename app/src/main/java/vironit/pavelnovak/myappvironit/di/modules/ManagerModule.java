package vironit.pavelnovak.myappvironit.di.modules;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import vironit.pavelnovak.myappvironit.mvp.model.manager.implementation.IResourcesManagerImpl;
import vironit.pavelnovak.myappvironit.mvp.model.manager.implementation.OAuthManagerImpl;
import vironit.pavelnovak.myappvironit.mvp.model.manager.interfaces.IOAuthManager;
import vironit.pavelnovak.myappvironit.mvp.model.manager.interfaces.IResourcesManager;

@Module
public interface ManagerModule {
    @Binds
    @Singleton
    IResourcesManager providesResourcesManager(IResourcesManagerImpl resourcesManagerImpl);

    /*@Binds
    @Singleton
    IOAuthManager providesOAuthManager(OAuthManagerImpl oAuthManager);*/
}
