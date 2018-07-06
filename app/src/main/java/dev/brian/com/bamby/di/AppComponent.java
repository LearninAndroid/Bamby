package dev.brian.com.bamby.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {AndroidInjectionModule.class,AppModule.class,ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder{
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }
}
