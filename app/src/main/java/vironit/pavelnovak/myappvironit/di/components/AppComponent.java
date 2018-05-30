package vironit.pavelnovak.myappvironit.di.components;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import vironit.pavelnovak.myappvironit.App;
import vironit.pavelnovak.myappvironit.di.modules.AppActivitiesModule;
import vironit.pavelnovak.myappvironit.di.modules.ApplicationModule;
import vironit.pavelnovak.myappvironit.di.modules.InteractorModule;
import vironit.pavelnovak.myappvironit.di.modules.ManagerModule;
import vironit.pavelnovak.myappvironit.di.modules.RepositoryModule;
import vironit.pavelnovak.myappvironit.di.modules.SchedulersModule;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.LoginPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.ProfilePresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.TestPresenter;

@Singleton
@Component(modules = {SchedulersModule.class,
        InteractorModule.class,
        ManagerModule.class,
        RepositoryModule.class,
        AppActivitiesModule.class,
        ApplicationModule.class})

public interface AppComponent {

    void inject(App app);

    void inject(TestPresenter testPresenter);

    void inject(LoginPresenter loginPresenter);

    void inject(ProfilePresenter profilePresenter);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder appContext(App app);
        AppComponent build();
    }

}
