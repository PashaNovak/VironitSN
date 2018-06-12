package vironit.pavelnovak.myappvironit.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import vironit.pavelnovak.myappvironit.di.annotations.ActivityScope;
import vironit.pavelnovak.myappvironit.di.annotations.FragmentScope;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.GoogleMapsActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.LoginActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.MainActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.SplashActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.activity.TestActivity;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.ChatFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.FeedFragment;
import vironit.pavelnovak.myappvironit.mvp.presentation.view.implementation.fragment.ProfileFragment;

@Module(includes = {AndroidSupportInjectionModule.class})
public interface AppActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    TestActivity testActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    LoginActivity loginActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    GoogleMapsActivity googleMapsActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    SplashActivity splashActivityInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    ChatFragment chateFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    ProfileFragment profileFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {ActivityModule.class})
    FeedFragment feedFragmentInjector();
}
