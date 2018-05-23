package vironit.pavelnovak.myappvironit.di.components;

import dagger.Component;
import vironit.pavelnovak.myappvironit.di.annotations.ActivityScope;
import vironit.pavelnovak.myappvironit.di.modules.ActivityModule;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {AppComponent.class})
public interface ActivityComponent {

}
