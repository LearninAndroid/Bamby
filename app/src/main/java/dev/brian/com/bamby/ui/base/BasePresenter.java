package dev.brian.com.bamby.ui.base;

import dev.brian.com.bamby.ui.base.exception.MvpViewNotAttached;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V mMvpView;

    @Override
    public void attachView(V mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAtttached(){
        return mMvpView !=null;
    }
    public V getmMvpView(){
        return mMvpView;
    }
    public void checkViewAttached(){
        if(!isViewAtttached()) throw new MvpViewNotAttached();
    }
}
