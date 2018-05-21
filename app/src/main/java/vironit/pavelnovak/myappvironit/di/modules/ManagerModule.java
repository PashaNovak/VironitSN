package vironit.pavelnovak.myappvironit.di.modules;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import vironit.pavelnovak.myappvironit.mvp.model.manager.implementation.ResourcesManagerImpl;
import vironit.pavelnovak.myappvironit.mvp.model.manager.interfaces.ResourcesManager;

@Module
public interface ManagerModule {
    @Binds
    @Singleton
    ResourcesManager providesResourcesManager(ResourcesManagerImpl resourcesManagerImpl);
}
