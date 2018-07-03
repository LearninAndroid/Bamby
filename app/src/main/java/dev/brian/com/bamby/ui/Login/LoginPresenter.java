package dev.brian.com.bamby.ui.Login;

public interface LoginPresenter {
    void onLoginConfirm(String username,String password);
    void onCheckUserExists(String username,String password);
}
