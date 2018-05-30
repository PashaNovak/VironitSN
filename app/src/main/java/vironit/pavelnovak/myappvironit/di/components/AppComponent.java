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
import vironit.pavelnovak.myappvironit.di.modules.RetrofitModule;
import vironit.pavelnovak.myappvironit.di.modules.SNModule;
import vironit.pavelnovak.myappvironit.di.modules.SchedulersModule;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.ChatPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.FeedPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.LoginPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.MainPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.ProfilePresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.presenter.TestPresenter;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.FeedFragment;

@Singleton
@Component(modules = {SchedulersModule.class,
        InteractorModule.class,
        ManagerModule.class,
        RepositoryModule.class,
        AppActivitiesModule.class,
        ApplicationModule.class,
        SNModule.class,
        RetrofitModule.class})

public interface AppComponent {

    void inject(App app);

    void inject(TestPresenter testPresenter);

    void inject(LoginPresenter loginPresenter);

    void inject(ProfilePresenter profilePresenter);

    void inject(FeedPresenter feedPresenter);

    void inject(ChatPresenter chatPresenter);

    void inject(MainPresenter mainPresenter);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder appContext(App app);
        AppComponent build();
    }

}
