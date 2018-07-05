package dev.brian.com.bamby;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class Bamby extends DaggerApplication {

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
       // return DaggerAppComponent.builder().application(this).build();
        return null;
    }
}
