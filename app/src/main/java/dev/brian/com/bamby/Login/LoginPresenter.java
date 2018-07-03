package dev.brian.com.bamby.Login;

public interface LoginPresenter {
    void onLoginConfirm(String username,String password);
    void onCheckUserExists(String username,String password);
}
