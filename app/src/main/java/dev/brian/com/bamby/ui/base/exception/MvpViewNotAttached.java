package dev.brian.com.bamby.ui.base.exception;

public  class MvpViewNotAttached extends RuntimeException {
    public MvpViewNotAttached(){
        super("Please Call Presenter.attachView(MvpView) before requesting data to the presenter");
    }
}
