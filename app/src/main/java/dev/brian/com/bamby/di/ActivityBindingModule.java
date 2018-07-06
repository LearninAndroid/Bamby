package dev.brian.com.bamby.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dev.brian.com.bamby.LoginActivity;
import dev.brian.com.bamby.ui.Register.RegisterActivity;

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract RegisterActivity registerActivity();

}
