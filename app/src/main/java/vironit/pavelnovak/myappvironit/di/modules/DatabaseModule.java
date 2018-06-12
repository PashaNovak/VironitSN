package vironit.pavelnovak.myappvironit.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vironit.pavelnovak.myappvironit.mvp.model.repository.db.VironitSocialNetworkDatabase;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    VironitSocialNetworkDatabase provideVironitSocialNetworkDatabase(Context context){
        return Room.databaseBuilder(context,
                VironitSocialNetworkDatabase.class,
                "VironitSocialNetworkDatabase.db")
                .build();
    }
}
