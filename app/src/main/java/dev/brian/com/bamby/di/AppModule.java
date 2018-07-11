package dev.brian.com.bamby.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dev.brian.com.bamby.ui.Navigation;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {

    @Provides
    static Navigation provideNavigator(){
        return new Navigation();
    }
    @Singleton
    @Provides
    static Realm providesRealm(){
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        return Realm.getInstance(realmConfiguration);
    }

    @Binds
    abstract Context bindContext(Application application);
}
