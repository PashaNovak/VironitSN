package vironit.pavelnovak.myappvironit.di.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vironit.pavelnovak.myappvironit.constants.IAppConstants;
import vironit.pavelnovak.myappvironit.mvp.model.repository.ApiInterface;
import vironit.pavelnovak.myappvironit.mvp.model.repository.ApiOAuthInterface;

@Module
public class ApiModule {

    @Provides
    @Singleton
    ApiInterface provideInterface(@Named(IAppConstants.NEWS) Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }

    /*@Provides
    @Singleton
    ApiOAuthInterface provideApiOAuthInterface(Retrofit retrofit){return retrofit.create(ApiOAuthInterface.class);}*/
}
