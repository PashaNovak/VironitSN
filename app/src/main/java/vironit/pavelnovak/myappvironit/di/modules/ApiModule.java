package vironit.pavelnovak.myappvironit.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vironit.pavelnovak.myappvironit.mvp.model.repository.ApiInterface;

@Module
public class ApiModule {

    @Provides
    @Singleton
    ApiInterface provideInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }
}
