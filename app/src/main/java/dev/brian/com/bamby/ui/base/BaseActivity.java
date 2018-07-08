package dev.brian.com.bamby.ui.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import dev.brian.com.bamby.di.AppComponent;
import dev.brian.com.bamby.di.DaggerAppComponent;

public class BaseActivity extends AppCompatActivity implements MvpView{

    private AppComponent mActivityComponent;
    private ProgressDialog mProgressDialog;

    public AppComponent activityComponent() {
        if(mActivityComponent == null){
            //mActivityComponent = DaggerAppComponent.builder().ac
        }
        return mActivityComponent;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
