package dev.brian.com.bamby;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dev.brian.com.bamby.di.DaggerAppComponent;
import io.realm.Realm;

public class Bamby extends DaggerApplication {

    @Override
    public void onCreate(){
        super.onCreate();
        try{
            Realm.init(this);
        }catch (RuntimeException ignore){

        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
       // return DaggerAppComponent.builder().application(this).build();
        return DaggerAppComponent.builder().application(this).build();
    }
}
